package com.zjk.my_app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;


import com.zjk.my_app.fragment.Car_news_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/4/18.
 */

public class MyfragmentpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList=
            new ArrayList<Fragment>();
    public MyfragmentpagerAdapter(FragmentManager fm) {
        super(fm);
    }




    //对外提供添加Fragment的方法
    public void addFragment(Fragment fragment){
        if(fragment!=null){
            fragmentList.add(fragment);
        }
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
           public void addFragMent(Fragment fragment){
               fragmentList.add(fragment);
           }


}
