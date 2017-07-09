package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baidu.mapapi.search.core.PoiInfo;

import com.zjk.my_app.R;
import com.zjk.my_app.imager.MyBitmapUtils;

import java.util.List;

public class SearchAdapter extends BaseAdapter {
    private Context context;
    private List<PoiInfo> list;

    private LayoutInflater inflater;
    public SearchAdapter(Context context, List<PoiInfo> list){
        this.context=context;
        this.list=list;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.include_search_item, null);
            viewHolder=new ViewHolder();
            viewHolder.tvName=(TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvAddress=(TextView) convertView.findViewById(R.id.tv_address);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(list.get(position).name);
        viewHolder.tvAddress.setText(list.get(position).address);
        return convertView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvAddress;
    }
}
