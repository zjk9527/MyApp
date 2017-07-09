package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.zjk.my_app.R;
import com.zjk.my_app.adapter.SystemBarTintManager;

/**
 * Created by zjk on 2017/5/6.
 */

public class BaseActivity extends Activity {
    public LinearLayout actionbar;//标题


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.blue);
        }
    }

    /**横屏**/
    public void setOrientationLandscape(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**竖屏**/
    public void setOrientationPortrait(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    /**
     *
     * @param leftId 左边图片资源Id
     * @param title 中间的文本内容
     * @param rightId 右边图片资源Id
     */
    public void initialActionbar(
            int leftId,
            String title,
            int rightId){
        if(actionbar==null){
            return;
        }
        ImageView imageView_Left= (ImageView)
                actionbar.findViewById(
                        R.id.imageView_Actionbar_Left);
        TextView textView_Title=
                (TextView) actionbar.findViewById(
                        R.id.textView_Actionbar_Title);
        ImageView imageView_Right= (ImageView)
                actionbar.findViewById(
                        R.id.imageView_Actionbar_Right);
        if(leftId==-1){
            //资源id如果为-1说明该控件不显示
            imageView_Left.setVisibility(View.INVISIBLE);
        }else{
            //说明要显示一个图片
            imageView_Left.setVisibility(View.VISIBLE);
            imageView_Left.setImageResource(leftId);
        }
        if(TextUtils.isEmpty(title)){
            textView_Title.setVisibility(View.INVISIBLE);
        }else{
            textView_Title.setVisibility(View.VISIBLE);
            textView_Title.setText(title);
        }
        if(rightId==-1){
            imageView_Right.setVisibility(View.INVISIBLE);
        }else {
            imageView_Right.setVisibility(View.VISIBLE);
            imageView_Right.setImageResource(rightId);
        }
    }

    Toast mToast;

    public void ShowToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

}
