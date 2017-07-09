package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zjk.my_app.entity.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/15.
 */

public class WeatherAdapter extends BaseAdapter{
   private List<Weather.ResultBean.TodayBean>weathers=new ArrayList<>();
    private Context context=null;
    public WeatherAdapter(Context context){
        this.context=context;
    }
    public void addWeathers(
            Weather.ResultBean.TodayBean weatherlist,
            boolean isClear){
        //如果要清空原始数据
        if(isClear){
            this.weathers.clear();
            this.weathers.add(weatherlist);
        }else{
            //不清空原始数据
            this.weathers.add(0,weatherlist);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
