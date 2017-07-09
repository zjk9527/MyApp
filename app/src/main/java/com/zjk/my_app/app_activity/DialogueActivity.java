package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zjk.my_app.R;
import com.zjk.my_app.util.ToastUtils;

public class DialogueActivity extends Activity {
    EditText roon_id;
    Button btn_look,btn_found,btn_chat;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        initView();
        setLietener();
    }

    private void setLietener() {
        //看直播
        btn_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLong(DialogueActivity.this,"该功能正在开发中...");
                /*int type=0;
                goNext(type);*/
            }
        });
        //创建直播间
        btn_found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLong(DialogueActivity.this,"该功能正在开发中...");
                /*int type=1;
                goNext(type);*/
            }
        });
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLong(DialogueActivity.this,"该功能正在开发中...");
            }
        });
    }

    private void initView() {
        roon_id= (EditText) findViewById(R.id.roon_id);
        btn_look= (Button) findViewById(R.id.btn_look);
        btn_found= (Button) findViewById(R.id.btn_found);
        btn_chat= (Button) findViewById(R.id.btn_chat);
    }
    private void goNext(int type) {
        String room_id=roon_id.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("type",type);
        intent.putExtra("roomId",room_id);
        intent.setClass(this,LiveActivity.class);
        startActivity(intent);
    }
}
