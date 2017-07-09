package com.zjk.my_app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.platform.comapi.map.A;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.BrandAdapter;
import com.zjk.my_app.app_activity.Brand_Model_Activity;
import com.zjk.my_app.entity.Brand;
import com.zjk.my_app.manager.BrandManager;

import com.zjk.my_app.util.ClearEditText;
import com.zjk.my_app.util.SideBar;
import com.zjk.my_app.util.TrainBiz;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 车型 按品牌
 */
public class An_brandFragment extends Fragment {

        //底部加载的布局
     View view,footer;
    BrandAdapter adapter6;
    ListView lv_brand;
    List<Brand.ResultBean>brandLists;
    SideBar sideBar;
    TextView tv_zm;
    ClearEditText clearEditText;

    public An_brandFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_an_brand, container, false);
        initViews();
        setListener();
        refreshBrand(false);

        return view;
    }



    private void initViews() {
        sideBar= (SideBar) view.findViewById(R.id.sidrbar);
        tv_zm= (TextView) view.findViewById(R.id.tv_zm);
        sideBar.setTextView(tv_zm);
        clearEditText= (ClearEditText) view.findViewById(R.id.clearEditText);
        lv_brand= (ListView) view.findViewById(R.id.lv_brand);
        adapter6=new BrandAdapter(getActivity());
        lv_brand.setAdapter(adapter6);
    }
    private void setListener() {
        lv_brand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), Brand_Model_Activity.class);
                String path=brandLists.get(position).getId();//下一级根据品牌来获取车型 例如   parentid=1
                String name=brandLists.get(position).getName();//品牌名字
                String logo=brandLists.get(position).getLogo();//品牌logo
               intent.putExtra("name",name);
                intent.putExtra("logo",logo);
                intent.putExtra("path",path);
                    startActivity(intent);
            }
        });
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                //int position= adapter6.get
            }
        });
        clearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //当输入框内容是空的 跟新为原来的列表 否则执行下面的方法 过滤数据列表
                String py=clearEditText.getText().toString();
                if (!TextUtils.isEmpty(py)){
                    String str=py.charAt(0)+"";
                    if (str.matches("[A-Z]") || str.matches("[a-z]")){
                        if (str.matches("[a-z]")){
                            //如果输入的为小写字母 将其变成大写的
                            //py=py.toLowerCase();大写变小写
                            py=py.toUpperCase();
                            List<Brand.ResultBean>list=TrainBiz.getTrainsByNumberTypeSelected(py,brandLists);
                            adapter6.addbrand(list,true);

                        }  else if (str.matches("[A-Z]")){
                            List<Brand.ResultBean>list=TrainBiz.getTrainsByNumberTypeSelected(py,brandLists);
                            adapter6.addbrand(list,true);
                        }
                    }else{
                        String hz=clearEditText.getText().toString();
                        List<Brand.ResultBean>list=TrainBiz.getTrainsByNumberTypeSelected1(hz,brandLists);
                        adapter6.addbrand(list,true);
                    }

                }
            }
        });
    }



    private void refreshBrand(final boolean isClear) {
        BrandManager.loadBrand(getContext(), new BrandManager.BrandLoadListener() {
            @Override
            public void onbrandLoadEnd(Brand brand) {
                List<Brand.ResultBean>brandlists=brand.getResult();
                An_brandFragment.this.brandLists=brandlists;
                adapter6.addbrand(brandLists,isClear);

            }
        });
    }
}
