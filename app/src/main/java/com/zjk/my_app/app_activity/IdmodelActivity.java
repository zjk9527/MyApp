package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.IdmodelAdapter;
import com.zjk.my_app.entity.IdModel;
import com.zjk.my_app.util.IdmodelManager;

import java.util.List;

public class IdmodelActivity extends Activity {
ImageView imageView_Actionbar_Left;
    TextView tv_titleName;//title 显示某某车系的所有车型
    ListView lv_idmodel;
    IdmodelAdapter adapter8;
    List<IdModel.ResultBean.ListBean>idmodelLists;
    String path1,titleName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idmodel);
        initViews();
        loadView();
        setListener();
        refreshBrand(false);
    }

    private void refreshBrand(final boolean isClear) {
        IdmodelManager.loadIdmodel(this, path1, new IdmodelManager.IdmodelLoadListener() {
            @Override
            public void onidmodelLoadEnd(IdModel idModel) {
                List<IdModel.ResultBean.ListBean>idmodellists=idModel.getResult().getList();
                IdmodelActivity.this.idmodelLists=idmodellists;
                adapter8.addidmodel(idmodelLists,isClear);
            }
        });
    }

    private void loadView() {
        path1=getIntent().getStringExtra("path1");
        titleName=getIntent().getStringExtra("fullname");
        tv_titleName.setText(titleName+"的全部车型");
    }

    private void initViews() {
        imageView_Actionbar_Left= (ImageView) findViewById(R.id.imageView_Actionbar_Left);
        tv_titleName= (TextView) findViewById(R.id.tv_fullname);
        lv_idmodel= (ListView) findViewById(R.id.lv_idmodel);
        adapter8=new IdmodelAdapter(this);
        lv_idmodel.setAdapter(adapter8);
    }
    private void setListener() {
        imageView_Actionbar_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(IdmodelActivity.this,Brand_Model_Activity.class);
               onBackPressed();
            }
        });

    }
}
