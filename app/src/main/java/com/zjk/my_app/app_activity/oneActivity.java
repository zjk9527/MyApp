package com.zjk.my_app.app_activity;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.util.SPUtils;



import static android.R.attr.animation;

/**第一界面
 * 第一次跳到广告界面
 *
 * */
public class oneActivity extends Activity implements Animation.AnimationListener {
    private String appId = "c46bf95c82e78765";
    private String appSecret = "ba669ff367af19e9";
    private Context context = this;
private RelativeLayout iv1;
    private TextView textView;
    private  int count=4;
    private Animation animation;
    private Handler handler1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Constant.HANDLER_SPLASH:
                    getCount();

                    finish();
                    break;

            }
        }
    };
    private int getCount() {
        count--;
        if (count == 0) {

            if (isFirst()){
                startActivity(new Intent(oneActivity.this,GuideActivity.class));

            }else{
                startActivity(new Intent(oneActivity.this,twoActivity.class));
                overridePendingTransition(R.anim.in_anim,R.anim.out_anim);
                finish();
            }
            finish();
        }
        return count;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        //在应用第一个 Activity（启动的第一个类）的 onCreate 中调用以下代码,初始化sdk(官网说的)
       // AdManager.getInstance(context).init(appId, appSecret, true);
        initView();
        if (!Constant.BMOB_APP_ID.isEmpty()) {
            initViews();
        }

    }



    private void initViews() {
        handler.sendEmptyMessageDelayed(Constant.HANDLER_SPLASH, 2000);
    }

    private void initView() {
        textView= (TextView) findViewById(R.id.textView);
        iv1= (RelativeLayout) findViewById(R.id.iv1);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.splash1);
       animation=AnimationUtils.loadAnimation(this,R.anim.text_anim);
        handler.sendEmptyMessageDelayed(0, 1000);


        anim.setAnimationListener(this);
        iv1.startAnimation(anim);
        //startActivity(new Intent(oneActivity.this,GuideActivity.class));
        //overridePendingTransition(R.anim.in_anim,R.anim.out_anim);

        //finish();
    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {
           // startActivity(new Intent(oneActivity.this,GuideActivity.class));
       //overridePendingTransition(R.anim.in_anim,R.anim.out_anim);
       //finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}

    private boolean isFirst(){
        boolean isFirst= SPUtils.getBoolean(this, Constant.SHARE_IS_FIRST,true);
        if (isFirst){
            SPUtils.putBoolean(this,Constant.SHARE_IS_FIRST,false);
            // 是第一次运行
            return true;
        }else{
            return false;
        }
    }
   private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                textView.setText(getCount()+"");
                handler.sendEmptyMessageDelayed(0, 1000);
                animation.reset();
                textView.startAnimation(animation);
            }

        }

    };




}
