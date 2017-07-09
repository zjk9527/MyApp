package com.zjk.my_app.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.natasa.progressviews.CircleSegmentBar;
import com.zjk.my_app.R;
import com.zjk.my_app.adapter.Weather1Adapter;
import com.zjk.my_app.entity.Weatherbean;
import com.zjk.my_app.fragment.MyFragment;
import com.zjk.my_app.manager.HttpWeatherManager;
import com.zjk.my_app.util.SpaceItemDecoration;

import java.util.List;

public class WeatherActivity extends Activity {
    ImageView iv_back,side;
    Handler handler=null;
    Runnable runnable=null;
    //侧滑界面布局
    private DrawerLayout drawer_navigation=null;
    //侧滑菜单
    private NavigationView navigation_view;
    //下拉功能
    SwipeRefreshLayout swipeRefreshLayout;
    Weather1Adapter adapter=null;
    RecyclerView recyclerView;
    TextView title_name,Update,week,weather_text,tv_newtime,tv_moon;
    SpaceItemDecoration decoration=null;
    CircleSegmentBar circleSegmentBar;
    List<Weatherbean.ResultBean.WeatherBeanX> weathers;
    FrameLayout fragmentLayout_ChartLine;
    String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        setListener();
        initialRealtime();

    }

    private void initialRealtime() {
        circleSegmentBar.setCircleViewPadding(5);
        circleSegmentBar.setWidth(280);
        circleSegmentBar.setWidthProgressBackground(30);
        circleSegmentBar.setWidthProgressBarLine(25);
        circleSegmentBar.setStartPositionInDegrees(90);
        circleSegmentBar.setLinearGradientProgress(true);
    }


    private void initView() {
        tv_newtime= (TextView) findViewById(R.id.tv_newtime);
        tv_moon= (TextView) findViewById(R.id.tv_moon);
        iv_back= (ImageView) findViewById(R.id.imageView_Actionbar_Left7);
        handler=new Handler();
        fragmentLayout_ChartLine= (FrameLayout) findViewById(R.id.fragmentLayout_ChartLine);
        side= (ImageView) findViewById(R.id.side);
        title_name= (TextView) findViewById(R.id.title_name);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        drawer_navigation= (DrawerLayout) findViewById(R.id.activity_weather);
        navigation_view= (NavigationView) findViewById(R.id.navigation_view);
        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefresh_weather);

        side.setColorFilter(Color.WHITE,
                PorterDuff.Mode.SRC_ATOP);



        //定义recycleview的每一项的间距
        decoration=new SpaceItemDecoration(10,10,20);

        //定义布局管理器
        LinearLayoutManager layoutManager=
                new LinearLayoutManager(this);
        //设置布局管理器的方向
        layoutManager.setOrientation(
                LinearLayoutManager.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(
                layoutManager);
        //设置recycleview的每一项的间距
        recyclerView.addItemDecoration(decoration);
        adapter=new Weather1Adapter(this);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.orange,
                R.color.bule,
                R.color.green);
        navigation_view.setItemIconTintList(null);

        /**
         * 刷新框中上半部分控件的初始化
         * Update 更新时间
         * week 星期
         *  circleSegmentBar 气温的圆形图片显示和seekbar类似
         *  weather_text 天气的状态
         * */
        Update= (TextView) findViewById(R.id.Update);

        circleSegmentBar= (CircleSegmentBar) findViewById(R.id.circleSegmentBar);
        week= (TextView) findViewById(R.id.week);
        weather_text= (TextView) findViewById(R.id.weather_text);

    }
    private void setListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WeatherActivity.this, MyFragment.class);
                finish();
            }
        });

        //为下拉刷行控件注册一个刷新的监听

        swipeRefreshLayout.setOnRefreshListener(new pullDownListener());
        //
        side.setOnClickListener(new myClickListener());
        //侧滑的菜单监听
        navigation_view.setNavigationItemSelectedListener(new nvgItemSelected());

    }
    private  class pullDownListener implements SwipeRefreshLayout.OnRefreshListener{
        @Override
        public void onRefresh() {
            refreshWeather(cityName,true);
        }
    }
    private  class nvgItemSelected implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            cityName=item.getTitle().toString();
            title_name.setText(cityName);
            refreshWeather(cityName,true);
            drawer_navigation.closeDrawer(Gravity.RIGHT);
            return true;
        }
    }
    private  class myClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.side:
                    drawer_navigation.openDrawer(Gravity.RIGHT);
                    break;
            }
        }
    }
    //加载天气的数据
    private void refreshWeather(String cityName,final boolean isClear){

        HttpWeatherManager.loadWeather(
                this,cityName,
                new HttpWeatherManager.WeatherLoadListener(){
                    @Override
                    public void onWeatherLoadEnd(Weatherbean weatherbean) {
                        List<Weatherbean.ResultBean.WeatherBeanX> weathers=
                                weatherbean.getResult().getWeather();
                        WeatherActivity.this.weathers=weathers;
                        adapter.addWeathers(weathers,isClear);
                        swipeRefreshLayout.setRefreshing(false);

                        Update.setText("跟新时间："+weatherbean.getResult().getPm25().getDateTime());
                        String weeknumb=weatherbean.getResult().getRealtime().getWeek()+"";
                        //week.setText("星期"+weatherbean.getResult().getData().getWeather().get(0).getWeek());
                        weather_text.setText(weatherbean.getResult().getRealtime().getWeather().getInfo()+" | 空气质量："+
                                weatherbean.getResult().getPm25().getPm25().getQuality());
                        tv_newtime.setText(weatherbean.getResult().getRealtime().getDate());
                        tv_moon.setText(weatherbean.getResult().getRealtime().getMoon());
                        String weekId=switchWeekDay(weeknumb);
                        week.setText(weekId);
                        int temp = Integer.parseInt(weatherbean.getResult()
                                .getRealtime().getWeather().
                                getTemperature());
                        //设置进度条的进度
                        setTemperature(temp);
                    }
                });
    }
    private String switchWeekDay(String weeknumb) {
        String weekId="";
        switch (weeknumb){
            case "1":
                weekId="星期一";
                break;
            case "2":
                weekId="星期二";
                break;
            case "3":
                weekId="星期三";
                break;
            case "4":
                weekId="星期四";
                break;
            case "5":
                weekId="星期五";
                break;
            case "6":
                weekId="星期六";
                break;
            case "7":
                weekId="星期日";
                break;
        }
        return  weekId;
    }
    private void setTemperature(final int temp) {
        handler.removeCallbacksAndMessages(null);
        runnable=new Runnable() {
            int progress=0;
            @Override
            public void run() {
                progress++;
                if(progress<(100*temp)/50){
                    circleSegmentBar.setProgress((float)progress);
                    circleSegmentBar.setText(String.valueOf(temp)+"°");
                    circleSegmentBar.setTextColor(Color.WHITE);
                    circleSegmentBar.setTextSize(50);
                }
                handler.postDelayed(runnable,100);
            }
        };
        handler.postDelayed(runnable,1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cityName = title_name.getText().toString();
        refreshWeather(cityName, false);
    }
    /*long l=Long.valueOf(value);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String date =simpleDateFormat.format(new Date(l));*/
}
