package com.zjk.my_app.app_activity;


import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.MyfragmentpagerAdapter;
import com.zjk.my_app.adapter.SystemBarTintManager;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.fragment.CarmodelFragment;
import com.zjk.my_app.fragment.CollectiFragment;
import com.zjk.my_app.fragment.MyFragment;
import com.zjk.my_app.fragment.NearbyFragment;
import com.zjk.my_app.fragment.NewsFragment;
import com.zjk.my_app.util.ToastUtils;



import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

import static cn.bmob.v3.Bmob.getApplicationContext;

public class twoActivity extends FragmentActivity{

    private RadioGroup rgroup;
    private ViewPager vPager;
    private MyfragmentpagerAdapter adapter;
    List<Fragment> fragments = null;
    CarmodelFragment carFragment = null;
    CollectiFragment collectiFragment = null;
    MyFragment myFragment = null;
    NearbyFragment nearbyFragment = null;
    NewsFragment newsFragment = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Bmob.initialize(this, Constant.BMOB_APP_ID);
        setOrientationPortrait();

        buildFragment();
        initialRadioGroup();
    }

    /**横屏**/
    public void setOrientationLandscape(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**竖屏**/
    public void setOrientationPortrait(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }




    private void buildFragment() {

        fragments = new ArrayList<>();
        newsFragment = new NewsFragment();
        carFragment = new CarmodelFragment();
        myFragment = new MyFragment();
        nearbyFragment = new NearbyFragment();
        collectiFragment = new CollectiFragment();
        fragments.add(newsFragment);
        fragments.add(carFragment);
        fragments.add(myFragment);
        fragments.add(nearbyFragment);
        fragments.add(collectiFragment);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        for(int i=0;i<fragments.size();i++){
            fragmentTransaction.add(R.id.rl_cotainer_fragment,fragments.get(i));
        }
        fragmentTransaction.commit();

    }


////初始化所有控件和fragment
    private void initialRadioGroup(){
        rgroup= (RadioGroup) findViewById(R.id.rgroup);
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index=rgroup.indexOfChild(rgroup.findViewById(checkedId));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                for(int i=0;i<fragments.size();i++){
                    fragmentTransaction.hide(fragments.get(i));
                }
                fragmentTransaction.show(fragments.get(index));
                fragmentTransaction.commit();
            }
        });
        RadioButton radioButton= (RadioButton) rgroup.findViewById(R.id.rbtn_my);
        radioButton.setChecked(true);
    }

    // 记录用户首次点击返回键的时间
    private long firstTime = 0;
    /**
     * 监听keyUp 实现双击退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                ToastUtils.showShort(this, "再按一次退出程序");
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyUp(keyCode, event);
    }
    @Override
    protected void onRestart() {

        super.onRestart();
    }
}
