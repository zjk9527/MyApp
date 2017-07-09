package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;

import com.zjk.my_app.R;

import java.io.File;

public class WebViewActivity extends Activity {
   private static final String APP_CACAHE_DIRNAME="/webcache";
    ImageView Actionbar_Left;
    WebView webView;
     String path = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_web_view);
        initialUI();

    }



    private void initialUI() {
        Actionbar_Left= (ImageView) findViewById(R.id.imageView_Actionbar_Left);
        webView= (WebView) findViewById(R.id.webView);

       webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        //设置webview缓存模式为（原始设定）
       webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //开启DOM storage  API功能
       webView.getSettings().setDomStorageEnabled(true);
        //开启database storage API功能
        webView.getSettings().setDatabaseEnabled(true);
        String cacheDirPath=getFilesDir().getAbsolutePath()+APP_CACAHE_DIRNAME;
        //Log.i("TAG","cacheDirPath="+cacheDirPath);
        //设置数据缓存路径
        webView.getSettings().setDatabasePath(cacheDirPath);
        //设置Application caches缓存目录
       webView.getSettings().setAppCachePath(cacheDirPath);
        //开启Application Caches功能
       webView.getSettings().setAppCacheEnabled(true);
        //优先先使用缓存
       webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
       //不使用缓存：
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        path=getIntent().getStringExtra("path");
        webView.loadUrl(path);
    }
    /**
     * 清除WebView缓存
     *
     * */
    public void clearWebViewCache(){
        //清理WebView缓存数据
        try{
            deleteDatabase("webview.db");
            deleteDatabase("webviewCache.db");
        }catch (Exception e){
        e.printStackTrace();
        }
        //WebView缓存文件
        File appCacheDir=new File(getFilesDir().getAbsolutePath()+APP_CACAHE_DIRNAME);
        Log.e("TAG","appCacheDir path="+appCacheDir.getAbsolutePath());

        File webviewCacheDir = new File(getCacheDir().getAbsolutePath()+"/webviewCache");
        Log.e("TAG","webviewCacheDir path="+webviewCacheDir.getAbsolutePath());
        //删除缓存目录
        if (webviewCacheDir.exists()){
              deleteFile(webviewCacheDir);
        }
        if (appCacheDir.exists()){
            deleteFile(appCacheDir);
        }
    }
     /**
      * 删除文件/文件夹
      * **/
    private void deleteFile(File file) {
        if (file.exists()){
            if (file.isFile()){
                file.delete();
            } else if (file.isDirectory()){
                File files[]=file.listFiles();
                for (int i=0;i<files.length;i++){
                    deleteFile(files[i]);
                }
            }
            file.delete();
        } else{
            Log.e("TAG","delete file no exists "+file.getAbsolutePath());
        }
    }

    public void onClickwebView(View v){
        switch (v.getId()){
            case R.id.imageView_Actionbar_Left:
                onBackPressed();
        }
    }

}
