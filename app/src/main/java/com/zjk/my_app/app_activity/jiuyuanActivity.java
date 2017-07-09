package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zjk.my_app.R;

public class jiuyuanActivity extends Activity {
private ImageView imageView_Actionbar_Left3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiuyuan);
        initViews();
        setListener();
    }

    private void initViews() {
        imageView_Actionbar_Left3= (ImageView) findViewById(R.id.imageView_Actionbar_Left3);

    }

    private void setListener() {

    }

    public void onClickjiuyuan(View view){
        switch (view.getId()){
            case R.id.imageView_Actionbar_Left3:
                onBackPressed();
        }
    }
}
