package com.zjk.my_app.app_activity;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zjk.my_app.R;
import com.zjk.my_app.entity.User;
import com.zjk.my_app.fragment.CollectiFragment;
import com.zjk.my_app.util.LogUtils;
import com.zjk.my_app.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;


/**
 * 注册界面
 *
 * 导入butterknife 包  省去了findViewById
 * */

public class RegisterActivity extends Activity {


    @BindView(R.id.et_phone) EditText mPhone;  //手机号
    @BindView(R.id.et_code)EditText mCode;//验证码
    @BindView(R.id.tv_code) TextView mBtnCode;
    @BindView(R.id.et_name)EditText mName;//用户名
    @BindView(R.id.et_pass)EditText mPass;// 密码
    @BindView(R.id.et_password)EditText mPassword;// 再次输入密码
    @BindView(R.id.et_desc)EditText mDesc;//个人介绍
    @BindView(R.id.rg_sort)RadioGroup mRadioGroup;

    private String classes ;// 类别
    private MyCountTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
//发送验证码
    @OnClick(R.id.tv_code)
    public void onSMSCodeButton(View view){
        String phoneNum = mPhone.getText().toString().trim();
        if (phoneNum.isEmpty()) {
            ToastUtils.showLong(this,"手机号不能为空");
            return;
        }
        timer = new MyCountTimer(60000, 1000);
        timer.start();
        BmobSMS.requestSMSCode(phoneNum,"default",new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId,BmobException e) {
                LogUtils.i("JAVA", e.toString());
                if (e==null) {// 验证码发送成功
                    ToastUtils.showShort(getApplicationContext(), "验证码发送成功");
                    Log.i("JAVA", "短信id："+smsId);// 用于查询本次短信发送详情
                } else {
                }
            }
        });
    }
    /**
     * 倒计时器
     * 停止倒计时器用 timer.cancel();
     */
    class MyCountTimer extends CountDownTimer {
        public MyCountTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            mBtnCode.setText((millisUntilFinished / 1000) +"秒后重发");
        }
        @Override
        public void onFinish() {
            mBtnCode.setText("重新发送验证码");
        }
    }

    @OnClick(R.id.btn_register)
    public void onRegistered(View view) {
        // 获取到输入框的值
        String phone = mPhone.getText().toString().trim();
        String code = mCode.getText().toString().trim();
        String name = mName.getText().toString().trim();
        String pass = mPass.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String desc = mDesc.getText().toString().trim();

        if (!TextUtils.isEmpty(name) &!TextUtils.isEmpty(pass) &
                !TextUtils.isEmpty(password) & !TextUtils.isEmpty(phone)) {
            if (pass.equals(password)) {
                // 判断类别
                //选择radio 
                selectRadioBtn();
                mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        selectRadioBtn();
                    }
                });

                if (TextUtils.isEmpty(desc)) {
                    desc = "这个人很懒，什么都没有留下!";
                }
                User user = new User();
                user.setMobilePhoneNumber(phone);
                user.setName(name);
                user.setPassword(password);

                user.setClasses(classes);
                user.setDesc(desc);

                user.signOrLogin(code, new SaveListener<User>() {
                    @Override
                    public void done(User user,BmobException e) {
                        if(e==null){
                            ToastUtils.showShort(RegisterActivity.this,"注册成功");
                            Log.i("JAVA", ""+user.getUsername()+"-"+user.getObjectId());
                            finish();
                        }else{
                            ToastUtils.showShort(RegisterActivity.this, "注册失败：" + e.toString());
                        }
                    }

                });
            } else {
                ToastUtils.showShort(this, "两次输入的密码不一致");
            }
        } else {
            ToastUtils.showShort(this,"输入框信息不完整");
        }

    }

    private void selectRadioBtn() {
        RadioButton  radioButton= (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
       classes=radioButton.getText().toString();
        Log.i("TAG", "radioButton="+classes);
    }


    @OnClick(R.id.imageView_Actionbar_Left1)
    public void onClick(View view){
    Intent intent=new Intent(RegisterActivity.this,logonActivity.class);
    onBackPressed();

}

}
