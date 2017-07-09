package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.adapter.PumpAdapter;
import com.zjk.my_app.entity.Pump;
import com.zjk.my_app.manager.PumpManager;

public class jiayouzhanActivity extends Activity {
    ImageView imageView_Actionbar_Left2;
    // 城市   89号汽油  92号汽油  95号汽油  97号汽油  90号汽油  93号汽油  0号柴油  省份
    TextView tv_state, tv_oil89, tv_oil92, tv_oil95, tv_oil97, tv_oil90, tv_oil93, tv_oil0, tv_updatetime;
    DrawerLayout drawerLayout_jiayouzhan;
    SwipeRefreshLayout swipeRefreshLayout1;
    NavigationView navigation_state;
    Pump.ResultBean pumpListener;
    PumpAdapter adapter;
    private String cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiayouzhan);
        initViews();
        setListener();


    }

    private void initViews() {
        imageView_Actionbar_Left2 = (ImageView) findViewById(R.id.imageView_Actionbar_Left2);
        tv_state = (TextView) findViewById(R.id.state);
        tv_oil89 = (TextView) findViewById(R.id.oil89);
        tv_oil92 = (TextView) findViewById(R.id.oil92);
        tv_oil95 = (TextView) findViewById(R.id.oil95);
        tv_oil97 = (TextView) findViewById(R.id.oil97);
        tv_oil90 = (TextView) findViewById(R.id.oil90);
        tv_oil93 = (TextView) findViewById(R.id.oil93);
        tv_oil0 = (TextView) findViewById(R.id.oil0);
        tv_updatetime = (TextView) findViewById(R.id.updatetime);
        drawerLayout_jiayouzhan = (DrawerLayout) findViewById(R.id.drawerLayout_jiayouzhan);

        adapter = new PumpAdapter(this);
        navigation_state = (NavigationView) findViewById(R.id.navigation_state);
        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        swipeRefreshLayout1.setColorSchemeResources(
                R.color.orange,
                R.color.bule,
                R.color.green);
    }




    private void setListener() {
        //为下拉刷新控件设置刷新监听
        tv_state.setOnClickListener(new myClickListener());
        navigation_state.setNavigationItemSelectedListener(new nvgItemSelected());
        swipeRefreshLayout1.setOnRefreshListener(new pullDownListener());

    }

    public void onClickjiayuzhan(View view) {
        switch (view.getId()) {
            case R.id.imageView_Actionbar_Left2:
                onBackPressed();
        }
    }






    private class pullDownListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            refreshWeather(cityName, false);
        }
    }


    private class myClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.state:
                    drawerLayout_jiayouzhan.openDrawer(Gravity.RIGHT);
                    break;
            }
        }
    }

    private class nvgItemSelected implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            cityName = item.getTitle().toString();
            tv_state.setText(cityName);
            refreshWeather(cityName, true);
            drawerLayout_jiayouzhan.closeDrawer(Gravity.RIGHT);
            return true;
        }
    }

    //加载天气的数据
    private void refreshWeather(String cityName, final boolean isClear) {
        PumpManager.loadPump(this, cityName, new PumpManager.PumpLoadListener() {
            @Override
            public void onPumpLoadEnd(Pump pump) {
                Pump.ResultBean pumpListeners = pump.getResult();
                jiayouzhanActivity.this.pumpListener = pumpListeners;
                adapter.addpump(pumpListeners, isClear);
                swipeRefreshLayout1.setRefreshing(false);
                String oil89 = pump.getResult().getOil89();
                String oil92 = pump.getResult().getOil92();
                String oil95 = pump.getResult().getOil95();
                String oil97 = pump.getResult().getOil97();
                String oil90 = pump.getResult().getOil90();
                String oil93 = pump.getResult().getOil93();
                String oil0 = pump.getResult().getOil0();
                String updatetime = pump.getResult().getUpdatetime();

                tv_oil89.setText(oil89 + "元");
                tv_oil92.setText(oil92 + "");
                tv_oil95.setText(oil95 + "元");
                tv_oil97.setText(oil97 + "元");
                tv_oil90.setText(oil90 + "元");
                tv_oil93.setText(oil93 + "元");
                tv_oil0.setText(oil0 + "元");
                tv_updatetime.setText(updatetime);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String cityName = tv_state.getText().toString();
        refreshWeather(cityName, false);
    }
}
