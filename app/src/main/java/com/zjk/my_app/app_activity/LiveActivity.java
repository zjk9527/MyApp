package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;

import com.ucloud.ulive.UCameraProfile;
import com.ucloud.ulive.UEasyStreaming;
import com.ucloud.ulive.UStreamingProfile;
import com.ucloud.ulive.filter.video.gpu.USkinBeautyGPUFilter;
import com.ucloud.ulive.widget.UAspectFrameLayout;
import com.ucloud.uvod.UMediaProfile;
import com.ucloud.uvod.widget.UVideoView;
import com.zjk.my_app.R;

public class LiveActivity extends Activity {
    private int type;
    private String roonID;
    private TextureView textureView;
    private UEasyStreaming mEasyStreaming;
    private String mRtmpAddress;
    private UVideoView mVideoView;
    private UAspectFrameLayout aspectFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        roonID = intent.getStringExtra("roomId");//设置地址
        mRtmpAddress = "rtmp://publish3.cdn.ucloud.com.cn/ucloud/" + roonID;
        textureView = (TextureView) findViewById(R.id.textureView);
        aspectFrameLayout = (UAspectFrameLayout) findViewById(R.id.uafl);
        mVideoView = (UVideoView) findViewById(R.id.uVideoView);

       switch (type) {case 0:
              mVideoView.setVisibility(View.VISIBLE);
             aspectFrameLayout.setVisibility(View.GONE);
                showLive();
                break;
            case 1:
                aspectFrameLayout.setVisibility(View.VISIBLE);
               mVideoView.setVisibility(View.GONE);
                pullStreaming();
                break;
        }
    }
    /**
     * 看直播
     */
    private void showLive() {
        UMediaProfile profile = new UMediaProfile();

        // 是否自动播放：0 - 需调用start开始播放；1 - 自动播放
        profile.setInteger(UMediaProfile.KEY_START_ON_PREPARED, 1);

        // 播放类型：0 - 点播；1 - 直播
        profile.setInteger(UMediaProfile.KEY_LIVE_STREAMING, 1);

        // 解码类型：0 - 软解；1 - 硬解
        profile.setInteger(UMediaProfile.KEY_MEDIACODEC, 0);

        // 是否允许后台播放：0 - 不允许；1 - 允许
        profile.setInteger(UMediaProfile.KEY_ENABLE_BACKGROUND_PLAY, 0);

        mVideoView.setMediaPorfile(profile);

        // 设置视频比例，默认VIDEO_RATIO_FIT_PARENT
        mVideoView.applyAspectRatio(UVideoView.VIDEO_RATIO_MATCH_PARENT);
        mVideoView.setVideoPath(mRtmpAddress);
        mVideoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mEasyStreaming!=null){
            mEasyStreaming.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mEasyStreaming!=null){
            mEasyStreaming.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        if(mEasyStreaming!=null){
            mEasyStreaming.onDestroy();
        }
        super.onDestroy();
    }

    public void stopShow(View v){
        if (mEasyStreaming != null) {
            mEasyStreaming.stopRecording();
        }
    }

    public void changeCam(View v){
        if (mEasyStreaming != null) {
            mEasyStreaming.switchCamera();
        }
    }

    /**
     * 直播推流
     */
    private void pullStreaming() {
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();

                //获取推流对象
                mEasyStreaming = UEasyStreaming.Factory.newInstance();

                //参数设置类，可设置类型包括音频、视频、摄像头、滤镜
                UCameraProfile cameraProfile=new UCameraProfile();
                //设置为后置摄像头
                cameraProfile.setCameraIndex(UCameraProfile.CAMERA_FACING_BACK);
                UStreamingProfile mStreamingProfile =
                        new UStreamingProfile.Builder()
                                .setCameraProfile(cameraProfile)
                                .setRtmpUrl(mRtmpAddress).build();
                //准备好推流
                mEasyStreaming.prepare(mStreamingProfile);
                //启动推流
                mEasyStreaming.startRecording();
                Looper.loop();
            }
        }.start();
        initTextureView();
    }

    private void initTextureView() {

        textureView.setKeepScreenOn(true);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(final SurfaceTexture surface, final int width, final int height) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mEasyStreaming == null) {
                            handler.postDelayed(this, 500);
                        } else {
                            Toast.makeText(LiveActivity.this, "直播开始", Toast.LENGTH_SHORT).show();
                            mEasyStreaming.startPreview(surface, width, height);
                            USkinBeautyGPUFilter mSkinBeautyGPUFilter = new USkinBeautyGPUFilter();
                            // level1: 磨皮；level2: 美白；level3: 红润；
                            mSkinBeautyGPUFilter.setFilterLevel(60, 26, 14);
                            mEasyStreaming.setVideoGPUFilter(mSkinBeautyGPUFilter);
                        }
                    }
                }, 500);

            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {

            }
        });
    }
}
