package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zjk.my_app.R;

public class baoxianActivity extends BaseActivity {
ImageView imageView_Actionbar_Left1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baoxian);
        imageView_Actionbar_Left1= (ImageView) findViewById(R.id.imageView_Actionbar_Left1);

    }

    public void onClickbaoxian(View v){
        switch (v.getId()){
            case R.id.imageView_Actionbar_Left1:
                onBackPressed();
        }
    }
}
