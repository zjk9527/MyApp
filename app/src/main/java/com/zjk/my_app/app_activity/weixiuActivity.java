package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zjk.my_app.R;

public class weixiuActivity extends Activity {
private ImageView imageView_Actionbar_Left5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixiu);
        imageView_Actionbar_Left5= (ImageView) findViewById(R.id.imageView_Actionbar_Left5);
    }
    public void onClickweixiu(View view){
        switch (view.getId()){
            case R.id.imageView_Actionbar_Left5:
                onBackPressed();
        }
    }
}
