package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zjk.my_app.R;

public class ParkActivity extends Activity {
 ImageView imageView_Actionbar_Left4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        imageView_Actionbar_Left4= (ImageView) findViewById(R.id.imageView_Actionbar_Left4);
    }
    public void onClickpark(View view){
        switch (view.getId()){
            case R.id.imageView_Actionbar_Left4:
                onBackPressed();
        }
    }
}
