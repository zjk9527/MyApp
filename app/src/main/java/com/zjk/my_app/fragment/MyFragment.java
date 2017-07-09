package com.zjk.my_app.fragment;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import android.widget.GridView;
import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.PictureAdapter;
import com.zjk.my_app.adapter.WeatherAdapter;
import com.zjk.my_app.app_activity.MysetActivity;
import com.zjk.my_app.app_activity.ParkActivity;
import com.zjk.my_app.app_activity.RegisterActivity;
import com.zjk.my_app.app_activity.WeatherActivity;
import com.zjk.my_app.app_activity.baoxianActivity;
import com.zjk.my_app.app_activity.jiayouzhanActivity;
import com.zjk.my_app.app_activity.jiuyuanActivity;
import com.zjk.my_app.app_activity.logonActivity;
import com.zjk.my_app.app_activity.weixiuActivity;
import com.zjk.my_app.app_activity.xicheActivity;
import com.zjk.my_app.constant.Constant;
import com.zjk.my_app.entity.User;
import com.zjk.my_app.entity.Weather;
import com.zjk.my_app.manager.WeatherManager;
import com.zjk.my_app.util.CircleImageView;
import com.zjk.my_app.util.LogUtils;
import com.zjk.my_app.util.SPUtils;
import com.zjk.my_app.util.ToastUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;


import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;


/**
 * 我的  界面
 * 侧滑菜单
 * function   功能
 */
public class MyFragment extends Fragment {
    private DrawerLayout drawerLayout;//滑动
    private ImageView actionbar_img;//点击单出侧滑菜单
    private SwipeRefreshLayout swipeRefreshLayout_weather;//下拉刷新

    private ImageView iv_dw;//点位图片
    private TextView tv_city; //城市名称
    private TextView tv_newtime;//当前时间
    private TextView tv_date_y; //当前日期
    private TextView tv_weather;  //天气  晴/阴
    private TextView tv_temperature;//气温
  //  private TextView tv_week;//星期
    WeatherAdapter adapter = null;
    Weather.ResultBean.TodayBean weathers;
    private static final int msgKey1 = 1;

    //meun声明
    CircleImageView userphoto;
    TextView mName, mDesc, tv_login, mPerson;


    private GridView gridView;//界面中间菜单栏
    private NavigationView navigationView = null;

    private String[] titles = new String[]{"加油站","天气预报", "保险", "洗车", "维修", "救援", "停车场","添加"};
    private int[] images = new int[]{R.drawable.jiayouzhan, R.drawable.weather, R.drawable.baoxian, R.drawable.xiche, R.drawable.weixu,
            R.drawable.jiuyuan, R.drawable.park, R.drawable.add};
    //使用ArrayAdapter来对ListView的内容进行填充

    private android.support.v7.app.AlertDialog photoDialog;
    public static final String PHOTO_IMAGE_FILE_NAME = "fileImg.jpg";
    public static final int CAMERA_REQUEST_CODE = 100;
    public static final int IMAGE_REQUEST_CODE = 101;
    public static final int RESULT_REQUEST_CODE = 102;
    private static final int REQUEST_BLUETOOTH_PERMISSION = 10;
    private File tempFile = null;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        initViews();
        setListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (User.getCurrentUser() != null) {
            initView();

        }
    }


    private void initViews() {

        iv_dw = (ImageView) view.findViewById(R.id.iv_dw);
        tv_city = (TextView) view.findViewById(R.id.tv_city);
        tv_newtime = (TextView) view.findViewById(R.id.tv_newtime);
        new TimeThread().start();
        tv_date_y = (TextView) view.findViewById(R.id.tv_date_y);
        tv_weather = (TextView) view.findViewById(R.id.tv_weather);
        tv_temperature = (TextView) view.findViewById(R.id.tv_temperature);

        swipeRefreshLayout_weather = (SwipeRefreshLayout)
                view.findViewById(R.id.swipeRefreshLayout_weather);
        swipeRefreshLayout_weather.setColorSchemeResources(
                R.color.orange,
                R.color.bule,
                R.color.green);
        adapter = new WeatherAdapter(getContext());
        actionbar_img = (ImageView) view.findViewById(R.id.actionbar_img);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        gridView = (GridView) view.findViewById(R.id.gridView);
        navigationView = (NavigationView) view.findViewById(R.id.navigation_view);
        View drawview = navigationView.inflateHeaderView(R.layout.header_layout);
        userphoto = (CircleImageView) drawview.findViewById(R.id.userphoto);
        mName = (TextView) drawview.findViewById(R.id.tv_name1);
        mPerson = (TextView) drawview.findViewById(R.id.person);
        mDesc = (TextView) drawview.findViewById(R.id.tv_desc);
        tv_login = (TextView) drawview.findViewById(R.id.tv_login);
        navigationView.setItemIconTintList(null);
        PictureAdapter adapter = new PictureAdapter(titles, images, getActivity());
        gridView.setAdapter(adapter);


    }

    private void setListener() {
        /**
         * 点击下拉刷新控件
         *
         */
        swipeRefreshLayout_weather.setOnRefreshListener(new pullDownListener());
        actionbar_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.actionbar_img:
                        drawerLayout.openDrawer(Gravity.LEFT);
                        break;
                }
            }
        });
        /**
         * 点击gridView控件
         *
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), jiayouzhanActivity.class);
                        startActivity(intent);
                        break;

                    case  1:
                        startActivity(new Intent(getActivity(), WeatherActivity.class));
                        break;
                    case 2:
                        Intent intent1 = new Intent(getActivity(), baoxianActivity.class);
                        startActivity(intent1);
                        break;
                    case 3:
                        Intent intent2 = new Intent(getActivity(), xicheActivity.class);
                        startActivity(intent2);

                    case 4:
                        Intent intent3 = new Intent(getActivity(), weixiuActivity.class);
                        startActivity(intent3);
                        break;
                    case 5:
                        Intent intent4 = new Intent(getActivity(), jiuyuanActivity.class);
                        startActivity(intent4);
                        break;
                    case 6:
                        Intent intent5 = new Intent(getActivity(), ParkActivity.class);
                        startActivity(intent5);
                   break;
                    case 7:
                    ToastUtils.showLong(getActivity(),"该功能 正在开发中..");
                        break;
                }
            }
        });

        /**
         * 点击navigationView控件
         *
         */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.myset:
                        startActivityForResult(new Intent(getActivity(),MysetActivity.class),Constant.RESULT_UPDATE_EXIT_INFO);
                        break;
                    case R.id.mymsn:
                        Toast.makeText(getActivity(), "消息", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.myguanyu:
                        Toast.makeText(getActivity(), "关于", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.car_photo:
                        Toast.makeText(getActivity(), "收藏", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.register:
                        Toast.makeText(getActivity(), "注册", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getActivity(), RegisterActivity.class));
                        break;
                }
                return true;
            }
        });

        /**
         * 点击登录事件
         * @param v
         */
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), logonActivity.class), Constant.RESULT_UPDATE_INFO);
            }
        });

        /**
         * 头像点击事件
         * @param view
         */
        userphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BmobUser.getCurrentUser() == null) {
                    ToastUtils.showShort(getActivity(), "亲，请先登录！");
                } else {
                    showDialog();
                }
            }
        });
    }

    private class pullDownListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
        }
    }

    private void refreshWeather(String CityName, final boolean isClear) {
        WeatherManager.loadWeather(getContext(), CityName, new WeatherManager.WeathirLoadListener() {
            @Override
            public void onWeatherLoadEnd(Weather weather) {

                Log.i("TAG1", "weather=" + weather);

                Weather.ResultBean.TodayBean weathers =
                        weather.getResult().getToday();
                MyFragment.this.weathers = weathers;
                adapter.addWeathers(weathers, isClear);
                swipeRefreshLayout_weather.setRefreshing(false);
                String temperature = weather.getResult().getToday().getTemperature();
                String weatherText = weather.getResult().getToday().getWeather();
                String date_y = weather.getResult().getToday().getDate_y();
                // String week = weather.getResult().getToday().getWeek();


                tv_temperature.setText(temperature);
                tv_date_y.setText("天气更新时间：" + date_y);
                tv_weather.setText(weatherText);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        String CityName = tv_city.getText().toString();
        refreshWeather(CityName, false);
    }

    public class TimeThread extends Thread {
        @Override
        public void run() {
            super.run();
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mhandler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    long time = System.currentTimeMillis();
                    Date date = new Date(time);
                    SimpleDateFormat format =
                            new SimpleDateFormat("MM月dd日 HH时mm分ss秒 EEE");
                    tv_newtime.setText(format.format(date));
                    break;
                default:
                    break;
            }
        }
    };


    private void initView() {

        setViewVisibilityVisible(mName,mDesc,mPerson);
        setViewVisibilityGone(tv_login);
        if (BmobUser.getCurrentUser() != null) {
            User user = BmobUser.getCurrentUser(User.class);

            if (user.getAvatar() != null) {
              Glide.with(getActivity()).load(user.getAvatar().getFileUrl()).into(userphoto);
            }
            mName.setText(user.getName());

            mDesc.setText(user.getDesc());
           mPerson.setText(user.getClasses());


        }
    }


    /**
     * 设置空间隐藏, 不占位
     * @param views
     */
    public void setViewVisibilityGone(View... views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 设置空间显示
     * @param views
     */
    public void setViewVisibilityVisible(View... views) {
        for (View view : views) {
           view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 点击头像的提示对话框
     */
    private void showDialog() {
        photoDialog = new android.support.v7.app.AlertDialog.Builder(getActivity()).create();
        photoDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        photoDialog.show();
        Window window = photoDialog.getWindow();
        window.setContentView(R.layout.dialog_photo); // 修改整个dialog窗口的显示
        window.setGravity(Gravity.BOTTOM);

        WindowManager.LayoutParams lp = photoDialog.getWindow().getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(dm);
        lp.width = dm.widthPixels;
        photoDialog.getWindow().setAttributes(lp); // 设置宽度

        photoDialog.findViewById(R.id.btn_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCamera();
            }
        });
        photoDialog.findViewById(R.id.btn_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPicture();
            }
        });
        photoDialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoDialog.dismiss();
            }
        });
    }

    /**
     * 跳转相机
     */
    public void toCamera() {
        requestWESPermission(); // 安卓6.0以上需要申请权限
        photoDialog.dismiss();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // 调用系统的拍照功能
        // 判断内存卡是否可用，可用的话就进行储存
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_IMAGE_FILE_NAME)));
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }


    /**
     * 动态申请权限
     */
    private void requestWESPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                // 判断是否需要 向用户解释，为什么要申请该权限
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE))
                    ToastUtils.showShort(getActivity(),"Need write external storage permission.");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_BLUETOOTH_PERMISSION);
                return;
            } else {
            }
        } else {
        }
    }
    /**
     * 裁剪
     * @param uri
     */
    private void startPhotoZoom(Uri uri) {
        if (uri == null) {
            LogUtils.e("JAVA", "裁剪uri == null");
            return;
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // 裁剪宽高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪图片的质量
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        // 发送数据
        intent.putExtra("return-data", true);
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }

    /**
     * 设置icon并上传服务器
     * @param data
     */
    private void setImageToView(Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            final Bitmap bitmap = bundle.getParcelable("data");
            final BmobFile bmobFile = new BmobFile(bitmapToFile(bitmap));

            bmobFile.uploadblock(new UploadFileListener() {
                @Override
                public void done(BmobException e) {
                    if(e==null) {
                        // 此时上传成功
                        User user = new User();
                        user.setAvatar(bmobFile);// 获取文件并赋值给实体类
                        BmobUser bmobUser = BmobUser.getCurrentUser();
                        user.update(bmobUser.getObjectId(), new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    userphoto.setImageBitmap(bitmap);
                                    ToastUtils.showShort(getActivity(),"头像更新成功");
                                } else {
                                    ToastUtils.showShort(getActivity(),"头像更新失败");
                                }
                            }
                        });
                    } else {
                        ToastUtils.showShort(getActivity(),"头像更新失败");
                    }
                    // 既然已经设置了图片，我们原先的就应该删除
                    if (tempFile != null) {
                        tempFile.delete();
                        LogUtils.i("JAVA", "tempFile已删除");
                    }
                }
                @Override
                public void onProgress(Integer value) {
                    // 返回的上传进度（百分比）
                }
            });
        }
    }

    /**
     * Bitmap转File
     */
    public File bitmapToFile(Bitmap bitmap) {
        tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_IMAGE_FILE_NAME);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFile));
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)) {
                bos.flush();
                bos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
    }

    /**
     * 跳转相册
     */
    private void toPicture() {
        photoDialog.dismiss();
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }
    /**
     * 授权回调处理
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case REQUEST_BLUETOOTH_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 授权成功
                } else {
                    // 授权拒绝
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // 登录
            case Constant.RESULT_UPDATE_INFO:
                if (User.getCurrentUser()!=null) {
                    initView();
                }
                break;
            //mysetAcyivity里执行不了case Constant.RESULT_UPDATE_INFO:命令
          //这个是重新写了一个返回登录界面状态的方法
           /* case Constant.RESULT_UPDATE_INFO1:
                if (User.getCurrentUser()!=null) {

                    initViewaa();
                }
                break;*/
            // 退出登录
            case Constant.RESULT_UPDATE_EXIT_INFO:
                if (User.getCurrentUser()==null) {
                    setViewVisibilityGone(mName,mDesc,mPerson);
                    setViewVisibilityVisible(tv_login);
                }
                break;
            case IMAGE_REQUEST_CODE: // 相册数据
                if (data != null) {
                    startPhotoZoom(data.getData());
                }
                break;
            case CAMERA_REQUEST_CODE: // 相机数据
                tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_IMAGE_FILE_NAME);
                startPhotoZoom(Uri.fromFile(tempFile));
                break;
            case RESULT_REQUEST_CODE: // 有可能点击舍弃
                if (data != null) {
                    // 拿到图片设置, 然后需要删除tempFile
                    setImageToView(data);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        SPUtils.putImage(getActivity(), "profile_image",userphoto); // 保存
    }

   /* *//**
     * 退出登录
     *//*
    public void onExitUser() {
        // 兼容的 Material Design AlertDialog
        new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setMessage("确定退出吗?")
                // .setCancelable(false) // 设置点击Dialog以外的界面不消失，按返回键也不起作用
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 清除缓存用户对象
                        User.logOut();
                        // 现在的currentUser是null了
                        BmobUser currentUser = User.getCurrentUser();
                  MyFragment.this.getActivity().setResult(Constant.RESULT_UPDATE_INFO, new Intent());
                      // getActivity().finish();

                    }
                })
                .show();
    }*/


}


