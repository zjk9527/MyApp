package com.zjk.my_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.MyfragmentpagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RadioGroup rgroup1;
    private ViewPager vPager1;
    private MyfragmentpagerAdapter adapter1;

    List<Fragment> fragment1=null;

    //最新 界面
    Car_news_Fragment car_news_fragment = null;
    //导购界面
    Car_guide_Fragment car_guide_fragment = null;
    //评测页面
    Car_evaluation_Fragment car_evaluation_fragment = null;
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_news, container, false);

        buildFragment();
        initialRadioGroup();
        return view;
    }

    private void buildFragment() {
        fragment1 = new ArrayList<>();
        car_news_fragment=new Car_news_Fragment();
        car_guide_fragment=new Car_guide_Fragment();
        car_evaluation_fragment=new Car_evaluation_Fragment();
        fragment1.add(car_news_fragment);
        fragment1.add(car_guide_fragment);
        fragment1.add(car_evaluation_fragment);
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        for(int i=0;i<fragment1.size();i++){
            fragmentTransaction.add(R.id.relativeLayout_news,fragment1.get(i));
        }
        fragmentTransaction.commit();
    }

    private void initialRadioGroup() {

        rgroup1= (RadioGroup) view.findViewById(R.id.rgroup1);
        rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index=rgroup1.indexOfChild(rgroup1.findViewById(checkedId));
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                for(int i=0;i<fragment1.size();i++){
                    fragmentTransaction.hide(fragment1.get(i));
                }
                fragmentTransaction.show(fragment1.get(index));
                fragmentTransaction.commit();
            }
        });
        RadioButton radioButton= (RadioButton) rgroup1.findViewById(R.id.rbtn_car_news);
        radioButton.setChecked(true);
    }


}
