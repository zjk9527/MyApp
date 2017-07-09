package com.zjk.my_app.fragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.TextureMapView;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.SystemBarTintManager;


import cn.bmob.v3.Bmob;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by zjk on 2017/4/18.
 */

public abstract class BaseFragment extends Fragment {
    public abstract void initialUI();
    public LinearLayout actionbar;
    protected int mScreenWidth;
    protected int mScreenHeight;

    public static final String TAG = "bmob";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




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



}
