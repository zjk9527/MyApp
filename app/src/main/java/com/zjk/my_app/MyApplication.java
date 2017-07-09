package com.zjk.my_app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import com.ucloud.ulive.UStreamingContext;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.util.ConfigUtils;

import java.io.File;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by zjk on 2017/4/23.
 */
public class MyApplication extends Application {
    public static MyApplication app;
    public static Context instance;

    @Override
    public void onCreate() {
        app = this;
        super.onCreate();

        // 读取配置文件
        ConfigUtils.getInstance().readConfig();
        // 依赖注入框架ButterKnife
        ButterKnife.setDebug(butterknife.BuildConfig.DEBUG);
       UStreamingContext.init(getApplicationContext(), "accessKey");

        // 初始化Bmob
        if (!Constant.BMOB_APP_ID.isEmpty()) {
            BmobConfig config = new BmobConfig.Builder(this)
                    .setApplicationId(Constant.BMOB_APP_ID)// 设置appkey
                    .setConnectTimeout(30)// 请求超时时间（单位为秒）：默认15s
                    .setUploadBlockSize(1024 * 1024)// 文件分片上传时每片的大小（单位字节），默认512*1024
                    .setFileExpiration(2500)// 文件的过期时间(单位为秒)：默认1800s
                    .build();
            Bmob.initialize(config);
            initImageLoader(this);

        }
    }
    private void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                // 缓存路径
                .diskCache(new UnlimitedDiskCache(cacheDir)).writeDebugLogs()
                // connectTimeout (10 s), readTimeout (10 s)  超时时间
                .imageDownloader(new BaseImageDownloader(context, 10 * 1000, 10 * 1000))
                // 缓存的文件数量
                .diskCacheFileCount(100)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
