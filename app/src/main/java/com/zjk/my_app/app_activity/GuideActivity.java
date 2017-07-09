package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    // 容器
    private List<View> mList = new ArrayList<>();
    private View view1, view2, view3;
    // 小圆点
    private ImageView point1, point2, point3;
    // 跳过
    private ImageView iv_back;
    //首发
    private TextView StoreName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        /*try{
            String packageName=getPackageName();
            PackageManager packageManager=getPackageManager();
            ApplicationInfo applicationInfo=packageManager.getApplicationInfo(packageName,
                    PackageManager.GET_META_DATA);
            String UMENG_CHANNEL_VALUE=applicationInfo.metaData.getString("UMENG_CHANNEL");
           StoreName= (TextView) findViewById(R.id.appStoreName);
           StoreName.setText(UMENG_CHANNEL_VALUE+"首发");

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    /**
     * 初始化View
     */
    private void initView() {
       // StoreName= (TextView) findViewById(R.id.appStoreName);
        point1 = (ImageView) findViewById(R.id.point1);
        point2 = (ImageView) findViewById(R.id.point2);
        point3 = (ImageView) findViewById(R.id.point3);

        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        // 设置默认图片
        setPointImg(true, false, false);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        view1 = View.inflate(this, R.layout.pager_item1, null);
        view2 = View.inflate(this, R.layout.pager_item2, null);
        view3 = View.inflate(this, R.layout.pager_item3, null);
        view3.findViewById(R.id.btn_start).setOnClickListener(this);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);

        // 设置适配器
        mViewPager.setAdapter(new GuideAdapter());

        // 监听ViewPager滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // pager切换
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setPointImg(true, false, false);
                        iv_back.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setPointImg(false, true, false);
                        iv_back.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setPointImg(false, false, true);
                        iv_back.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
            case R.id.iv_back:
                startActivity(new Intent(this, twoActivity.class));
                finish();
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(mList.get(position));
            // super.destroyItem(container, position, object);
        }
    }

    // 设置小圆点的选中效果
    private void setPointImg(boolean isCheck1, boolean isCheck2, boolean isCheck3) {
        if (isCheck1) {
            point1.setBackgroundResource(R.drawable.point_on);
        } else {
            point1.setBackgroundResource(R.drawable.point_off);
        }

        if (isCheck2) {
            point2.setBackgroundResource(R.drawable.point_on);
        } else {
            point2.setBackgroundResource(R.drawable.point_off);
        }

        if (isCheck3) {
            point3.setBackgroundResource(R.drawable.point_on);
        } else {
            point3.setBackgroundResource(R.drawable.point_off);
        }
    }
}
