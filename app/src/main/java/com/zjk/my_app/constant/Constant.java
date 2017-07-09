package com.zjk.my_app.constant;


import android.os.Build;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.zjk.my_app.R;

/**
 * Created by zjk on 2017/4/22.
 */

public class Constant {
    //RESULT
    public final static int RESULT_UPDATE_INFO = 1;
    //RESULT
    public final static int RESULT_UPDATE_EXIT_INFO = 2;
    //闪屏业延时
    public static final int HANDLER_SPLASH = 1001;
    //判断程序是否是第一次运行
    public static final String SHARE_IS_FIRST = "isFirst";

    //Bmob key
    public static final String BMOB_APP_ID = "4fcb0356056456d1c4763ea8c0d38ee2";

    public static ImageLoader getImageLoader(){return ImageLoader.getInstance();}

    public  static DisplayImageOptions getDisplayImageOptions(){
       return  new DisplayImageOptions.Builder().
                showImageOnLoading(R.drawable.i)//设置图片在下载期间显示的图片
               .showImageForEmptyUri(R.drawable.i)//设置图片uri为空 会发生错误是显示的照片
               .showImageOnFail(R.drawable.i)//设置图片在加载或解析时发生的时候显示的照片
               .displayer(new FadeInBitmapDisplayer(500))//是否在图片加载好了后显示渐入动画的时间
               .cacheInMemory(true)
               .cacheOnDisk(true)
               .build();
    }


}
