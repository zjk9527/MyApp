package com.zjk.my_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.MyfragmentpagerAdapter;


/**
 *
 */
public class CarmodelFragment extends Fragment {
private MyfragmentpagerAdapter adapter;
    private ViewPager viewPager_model;
    private RadioGroup rgroup2;

    An_brandFragment anBrandFragment=null;
    An_conditionkFragment anConditionkFragment=null;
public View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_car_model, container, false);
        initialFragments();
        setListener();
    return view;
    }

    private void setListener() {
        viewPager_model.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
             switch (position){
                 case 0:
                    rgroup2.check(R.id.rbtn_an_brand);
                     break;
                 case 1:
                     rgroup2.check(R.id.rbtn_an_condition);
                     break;
                 default:
                     break;
}
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rgroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case  R.id .rbtn_an_brand:
                            viewPager_model.setCurrentItem(0,false);
                            break;
                        case R.id.rbtn_an_condition:
                            viewPager_model.setCurrentItem(1,false);
                            break;
                        default:
                            break;

                    }
            }
        });
        RadioButton rbtn_an_brand= (RadioButton) view.findViewById(R.id.rbtn_an_brand);
        
    }
//初始化
    private void initialFragments() {
        viewPager_model= (ViewPager) view.findViewById(R.id.viewPager_model);
        rgroup2= (RadioGroup) view.findViewById(R.id.rgroup2);
        anBrandFragment=new An_brandFragment();
        anConditionkFragment=new An_conditionkFragment();
        adapter=new MyfragmentpagerAdapter(getActivity().getSupportFragmentManager());
adapter.addFragment(anBrandFragment);
        adapter.addFragment(anConditionkFragment);
        viewPager_model.setAdapter(adapter);
viewPager_model.setCurrentItem(0,false);

    }

}
