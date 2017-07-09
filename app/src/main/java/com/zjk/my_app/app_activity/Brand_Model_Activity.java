package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.widget.AdapterView;
import android.widget.ImageView;


import android.widget.ListView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.ModelAdapter;

import com.zjk.my_app.entity.Model;
import com.zjk.my_app.fragment.An_brandFragment;
import com.zjk.my_app.manager.ModelManager;
import com.zjk.my_app.util.NormalLoadPictrue;

import java.util.List;



public class Brand_Model_Activity extends Activity {
    ImageView imageView_Actionbar_Left,iv_logo;
    TextView tv_name;
    ListView lv_brand_model;
 String path,logo,name;
   ModelAdapter adapter7;
    List<Model.ResultBean.ListBean> modelLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand__model_);
        initViews();

        loadViews();
        setListener();
        refreshBrand(false);
    }

    private void refreshBrand(final boolean isClear) {
        ModelManager.loadModel(this,path, new ModelManager.ModelLoadListener() {
            @Override
            public void onmodelLoadEnd(Model model) {
               List<Model.ResultBean.ListBean>modellists=model.getResult().get(0).getList();
                Brand_Model_Activity.this.modelLists=modellists;
                adapter7.addmodel(modelLists,isClear);
            }
        });


    }


    private void loadViews() {
        //上一级传过来的品牌Id  对应本界面数据的 parentid  放在JSON网址后面的
        path=getIntent().getStringExtra("path");
        logo=getIntent().getStringExtra("logo");

        //NormalLoadPictrue()自定义加载图片的方法

        new NormalLoadPictrue().getPicture(logo,iv_logo);


        name=getIntent().getStringExtra("name");
        tv_name.setText(name);
    }

    private void initViews() {
        imageView_Actionbar_Left= (ImageView) findViewById(R.id.imageView_Actionbar_Left);
        iv_logo= (ImageView) findViewById(R.id.iv_logo);
        tv_name= (TextView) findViewById(R.id.tv_name);
        lv_brand_model= (ListView) findViewById(R.id.lv_brand_model);
         adapter7=new ModelAdapter(this);
        lv_brand_model.setAdapter(adapter7);
    }
    private void setListener() {
lv_brand_model.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(Brand_Model_Activity.this,IdmodelActivity.class);
        String path1=modelLists.get(position).getId();
        String fullname=modelLists.get(position).getFullname();
        intent.putExtra("path1",path1);
        intent.putExtra("fullname",fullname);
        startActivity(intent);
    }
});

        imageView_Actionbar_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Brand_Model_Activity.this, An_brandFragment.class);
                onBackPressed();
            }
        });
    }



}
