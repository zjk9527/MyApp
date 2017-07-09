package com.zjk.my_app.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;


import com.zjk.my_app.util.StreamUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pjy on 2017/5/2.
 */

public class MyImageLoader {
    /**
     * 如果我要设置一个音乐的专辑图片，可以先从内存中查找，如果内存中
     * 有的话就直接使用，如果内存中没有的话，再去文件缓存中查找,
     * 如果文件缓存中有，那么就使用文件缓存中的图片，如果
     * 文件缓存中也没有要使用的图片，说明我从来没有从网络
     * 上加载过该图片，从网络上加载图片，并存入内存缓存，
     * 以及文件缓存。
     */
    //最近最少使用的内存缓存区域
    public static LruCache<String, Bitmap> lruCacheMemory = null;

    static {
        //该缓存区域能够存储的最的空间
        int maxSize = (int) Runtime.getRuntime().maxMemory() / 8;
        lruCacheMemory = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    /**
     * @param context   上下文
     * @param imageView 专辑图片控件
     * @param imageUrl  图片的路径
     */
    public static void setBitmapFromCache(
            Context context,
            ImageView imageView,
            String imageUrl) {
        //从缓存中获得的图片
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        //从内存中查找图片
        bitmap = getBitmapFromMemory(imageUrl);
        if (bitmap != null) {
            //设置图片到控件
            imageView.setImageBitmap(bitmap);
            return;
        }
        //文件缓存中查找图片
        bitmap = getBitmapFromFile(context, imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //从网络上异步加载图片
        loadBitmapFromHttp(context,imageView,imageUrl);
    }

    private static void loadBitmapFromHttp(
            Context context,
            ImageView imageView,
            String imageUrl) {

        MyAsyncTask task=new MyAsyncTask(context,imageView);
        task.execute(imageUrl);
    }

    public  static class MyAsyncTask extends AsyncTask<String,Void,Bitmap>{
        Context context;
        ImageView imageView=null;
        public MyAsyncTask(Context context,ImageView imageView){
            this.context=context;
            this.imageView=imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            //获得要加载的图片的url
            String path=params[0];
            Bitmap bitmap=null;

            try{
                URL url=new URL(path);
                HttpURLConnection connection=
                        (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setDoInput(true);

                connection.connect();
                //获得晌应的状态码
                int statusCode=connection.getResponseCode();
                if(statusCode==200){
                    InputStream is=connection.getInputStream();
                   // bitmap=BitmapFactory.decodeStream(is);
                   bitmap=compressBitmap(is);
                    if(bitmap!=null){
                        //将图片进行缓存处理
                        //存入内存
                        lruCacheMemory.put(path,bitmap);
                        //存入文件缓存
                        saveBitmapToFile(context,bitmap,path);
                        return bitmap;
                    }
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //把图片设置到控件上
            imageView.setImageBitmap(bitmap);
        }
    }

    /**
     * 对图片进行尺寸的压缩处理
     * @param is
     */
    private static Bitmap compressBitmap(InputStream is) {
        byte[] datas= StreamUtil.getByteArrayFromStream(is);
        BitmapFactory.Options options=new BitmapFactory.Options();
        //将选项的仅对图片进行边界处理的属性设置真
        options.inJustDecodeBounds=true;

        BitmapFactory.decodeByteArray(datas,0,datas.length,options);
        //获得图片边界的高度
        int outHeight=options.outHeight;
        int outWidth=options.outWidth;

        //设置压缩后的图片的目标宽度以及高度
        int targetHeight=90;
        int targetWidth=90;

        //计算压缩比例
        int blw=outWidth/targetWidth;
        int blh=outHeight/targetHeight;

        int bl=blw>blh?blw:blh;
        if(bl<=0){
            bl=1;
        }

        options.inSampleSize=bl;
        //将仅对边界进行处理的属性还原为false
        //带着压缩比例做图片的解码处理
        options.inJustDecodeBounds=false;
        Bitmap  bitmap=BitmapFactory.decodeByteArray(datas,0,datas.length,options);
        return bitmap;
    }

    /**
     * 将网络加载的图片保存到应用的缓存目录中
     * @param context
     * @param bitmap
     * @param path
     */
    private static void saveBitmapToFile(Context context, Bitmap bitmap, String path) {

      try {  //获得应用的缓存目录
          File cacheDir = context.getCacheDir();
          if (!cacheDir.exists()) {
              //如果缓存目录不存在的话创建一人缓存目录
              cacheDir.mkdirs();
          }
          //获得要缓存的文件的文件名
          String fileName = path.substring(path.lastIndexOf("/") + 1);
          //定义要缓存的文件对象
          File file = new File(cacheDir, fileName);
          OutputStream os = new FileOutputStream(file);
          bitmap.compress(Bitmap.CompressFormat.JPEG,100,os);
      }catch (Exception ex){
          ex.printStackTrace();
      }
    }


    private static Bitmap getBitmapFromMemory(String imageUrl) {
        Bitmap bitmap = lruCacheMemory.get(imageUrl);
        return bitmap;
    }

    private static Bitmap getBitmapFromFile(
            Context context,
            String imageUrl) {
        Bitmap bitmap = null;
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        //获得应用的缓存目录
        File cacheFile = context.getCacheDir();
        if (cacheFile != null) {
            //获得缓存目录下所有的文件对象
            File[] files = cacheFile.listFiles();
            for (File file : files) {
                String name = file.getName();
                if(name.equals(fileName)){
                    //文件缓存中有我要使用的图片
                    //将图片设置到控件上
                    bitmap= BitmapFactory.decodeFile(file.getAbsolutePath());
                    return bitmap;
                }
            }

        }
        return bitmap;
    }

}
