package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;

import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.entity.User;
import com.zjk.my_app.fragment.MyFragment;
import com.zjk.my_app.util.LogUtils;
import com.zjk.my_app.util.SPUtils;
import com.zjk.my_app.util.ToastUtils;
import com.zjk.my_app.view.CustomDialog;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;


/**账号登录界面*/

public class logonActivity extends Activity {
    private ImageView Actionbar_Left1,logo_qq,logo_weibo,logo_wechat;
    private EditText mPhone,mPassword;
    private Button login_button;
    private TextView register_link,find_password;
    private CustomDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        //初始化bmomsdk
        Bmob.initialize(this, Constant.BMOB_APP_ID);
        initViews();
        initView();
        setListener();
    }

    private void initView() {
        dialog = new CustomDialog(this, 100, 100, R.layout.dialog_loading, R.style.Theme_dialog, Gravity.CENTER, R.style.pop_anim_style);
        dialog.setCancelable(false);
        String phone = SPUtils.getString(this, "phone", "");
        String password = SPUtils.getString(this, "password", "");
        mPhone.setText(phone);
        mPassword.setText(password);
    }

    private void initViews() {
        Actionbar_Left1= (ImageView) findViewById(R.id.imageView_Actionbar_Left1);
        logo_qq= (ImageView) findViewById(R.id.logo_qq);
        logo_weibo= (ImageView) findViewById(R.id.logo_weibo);
        logo_wechat= (ImageView) findViewById(R.id.logo_wechat);
        mPhone= (EditText) findViewById(R.id.username_edit);
        mPassword= (EditText) findViewById(R.id.password_edit);
        login_button= (Button) findViewById(R.id.login_button);
        register_link= (TextView) findViewById(R.id.register_link);
        find_password= (TextView) findViewById(R.id.find_password);

    }
    private void setListener() {
        register_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logonActivity.this,RegisterActivity.class));
            }
        });
        Actionbar_Left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(logonActivity.this, MyFragment.class);
                onBackPressed();
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mPhone.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(phone) & !TextUtils.isEmpty(password)) {
                    dialog.show();
                    // 登录
                    BmobUser.loginByAccount(phone, password, new LogInListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            dialog.dismiss();
                            if (user != null) {
                                LogUtils.i("JAVA", "用户登陆成功");
                                logonActivity.this.setResult(Constant.RESULT_UPDATE_INFO, new Intent());
                                finish();
                            } else {
                                ToastUtils.showShort(getApplicationContext(),"登录失败"+ e.toString());
                            }
                        }
                    });
                } else {
                    ToastUtils.showShort(getApplicationContext(),"输入框不能为空");
                }
                /*Intent intent =new Intent(logonActivity.this,MyFragment.class);
                onBackPressed();*/
            }
        });
        find_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logonActivity.this,FindPassWordActivity.class));
            }
        });
    }
}

