package com.zjk.my_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.Brand;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/25.
 * 车型-->按品牌
 */

public class BrandAdapter extends BaseAdapter {
    List<Brand.ResultBean>beanList=new ArrayList<>();
    private Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    public BrandAdapter(Context context){
        this.context=context;
    }
    public void addbrand(List<Brand.ResultBean>brandLists,boolean isClear){
        if (isClear){
            this.beanList.clear();
            this.beanList.addAll(brandLists);
        }else{
            this.beanList.addAll(0,brandLists);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Brand.ResultBean getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.inlcude_brand,null);
            holder.iv_logo= (ImageView) convertView.findViewById(R.id.iv_logo);
            holder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_py= (TextView) convertView.findViewById(R.id.tv_a);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Brand.ResultBean resultBean=beanList.get(position);
        holder.tv_py.setText(resultBean.getInitial());
        String py = resultBean.getInitial();

        Log.i("TAG","py");
        if(position>=1) {
            Brand.ResultBean resultBean_last = beanList.get(position - 1);
            String py_last = resultBean_last.getInitial();
            if(py.equals(py_last)){
                holder.tv_py.setVisibility(View.GONE);
            } else {
                holder.tv_py.setVisibility(View.VISIBLE);
            }
        }if(position==0){
            holder.tv_py.setVisibility(View.VISIBLE);
        }
        String imagerUrl=resultBean.getLogo();
        utils.display(holder.iv_logo,imagerUrl);
        holder.tv_name.setText(resultBean.getName());
        return convertView;
    }
    public class ViewHolder{
        ImageView iv_logo;
        TextView tv_name;
        TextView tv_py;
    }
}
