package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.IdModel;
import com.zjk.my_app.entity.Model;
import com.zjk.my_app.entity.Picture;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjk on 2017/5/25.
 * 车型-->按品牌-按车型
 */

public class ModelAdapter extends BaseAdapter {


    private List<Model.ResultBean.ListBean> modelList = new ArrayList<>();
    private Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    public ModelAdapter(Context context) {
        this.context = context;
    }

    public void addmodel(List<Model.ResultBean.ListBean> modelLists, boolean isClear) {
        if (isClear) {
            this.modelList.clear();
            this.modelList.addAll(modelLists);
        } else {
            this.modelList.addAll(modelLists);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Model.ResultBean.ListBean getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.inlcude_model, null);

            holder.tv_fullname = (TextView) convertView.findViewById(R.id.tv_fullname);
            holder.tv_salestate = (TextView) convertView.findViewById(R.id.tv_salestate);
            holder.iv_logo = (ImageView) convertView.findViewById(R.id.iv_logo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model.ResultBean.ListBean listBean = modelList.get(position);
        String imageurl = listBean.getLogo();
        utils.display(holder.iv_logo, imageurl);
        holder.tv_fullname.setText(listBean.getFullname());
        holder.tv_salestate.setText(listBean.getSalestate());


        return convertView;
    }

    public class ViewHolder {
        TextView tv_fullname, tv_salestate;
        ImageView iv_logo;
    }

}