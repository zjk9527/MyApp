package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zjk.my_app.entity.Pump;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/24.
 */

public class PumpAdapter extends BaseAdapter {
    List<Pump.ResultBean> pumpListener=new ArrayList<>();
    private Context context;
    public PumpAdapter(Context context){this.context=context;}
    public void addpump(Pump.ResultBean pumpListeners,boolean isClear){
        if (isClear){
            this.pumpListener.clear();
            this.pumpListener.add(pumpListeners);
        }else{
            //不清空数据
            this.pumpListener.add(0,pumpListeners);
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
