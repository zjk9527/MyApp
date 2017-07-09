package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.zjk.my_app.R;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.entity.User;
import com.zjk.my_app.fragment.MyFragment;
import com.zjk.my_app.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

/**
 * Created by zjk on 2017/6/6.
 */
public class MysetActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView mListView;

    private static final String[] strs = new String[]{"修改密码", "用户协议", "关于我们", "退出"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_myset);
        ButterKnife.bind(this);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchActivity(position);
            }
        });
    }

    private void switchActivity(int position) {
        switch (position) {
            case 0: // 修改密码
                if (User.getCurrentUser()!=null) {
                    // startActivity(new Intent(this, ChangePasswordActivity.class));
                } else {
                    ToastUtils.showShort(this, "您并没有登录");
                }
                break;
            case 1: // 用户协议
                break;
            case 2: // 关于我们
                break;
            case 3: // 退出
                if (User.getCurrentUser()!=null) {
                    onExitUser();
                } else {
                    ToastUtils.showShort(this, "您并没有登录");
                }
                break;
            default:
                break;
        }
    }

    /**
     * 退出登录
     */
    public void onExitUser() {
        // 兼容的 Material Design AlertDialog
        new AlertDialog.Builder(this)
                .setMessage("确定退出吗?")
                // .setCancelable(false) // 设置点击Dialog以外的界面不消失，按返回键也不起作用
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 清除缓存用户对象
                        User.logOut();
                        Log.i("TAG", "清除的对象是");

                        // 现在的currentUser是null了
                        BmobUser currentUser = User.getCurrentUser();
                        //MysetActivity.this.setResult(, new Intent());
                        MysetActivity.this.setResult(Constant.RESULT_UPDATE_INFO, new Intent());

                        finish();
                    }
                })
                .show();
    }
    @OnClick(R.id.imageView_Actionbar_Left)
    public void onClick(){
        Intent intent=new Intent(MysetActivity.this,MyFragment.class);
        finish();
    }
}
