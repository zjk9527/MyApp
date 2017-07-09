package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zjk.my_app.R;

public class xicheActivity extends Activity {
private ImageView imageView_Actionbar_Left6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiche);
        imageView_Actionbar_Left6= (ImageView) findViewById(R.id.imageView_Actionbar_Left6);
    }
    public void onClickxiche(View view){
        switch (view.getId()){
            case R.id.imageView_Actionbar_Left6:
               onBackPressed();

        }
    }
}
