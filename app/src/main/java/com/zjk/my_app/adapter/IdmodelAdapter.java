package com.zjk.my_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.IdModel;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/6/5.
 * 车型 按品牌--按车型--具体车型
 */

public class IdmodelAdapter extends BaseAdapter {
    private List<IdModel.ResultBean.ListBean> idmodelList=new ArrayList<>();
   private  Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    public IdmodelAdapter(Context context) {this.context = context;}
    public void addidmodel(List<IdModel.ResultBean.ListBean> idmodelLists,boolean isClear) {
        if (isClear){
            this.idmodelList.clear();
            this.idmodelList.addAll(idmodelLists);
        }else{
            this.idmodelList.addAll(idmodelLists);
        }
      notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return idmodelList.size();
    }

    @Override
    public IdModel.ResultBean.ListBean getItem(int position) {
        return idmodelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.inlcude_model2,null);
            holder.iv_logo1= (ImageView) convertView.findViewById(R.id.iv_logo1);
            holder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_price= (TextView) convertView.findViewById(R.id.tv_price);
            holder.tv_salestate1= (TextView) convertView.findViewById(R.id.tv_salestate1);
            holder.tv_sizetype= (TextView) convertView.findViewById(R.id.tv_sizetype);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        IdModel.ResultBean.ListBean listBean=idmodelList.get(position);
        String imageurl=listBean.getLogo();
        //获取到了图片的url   但url错误
        Log.i("TAG4", "imageurl="+imageurl);
        utils.display(holder.iv_logo1,imageurl);
        holder.tv_name.setText(listBean.getName());
        holder.tv_price.setText(listBean.getPrice());
        holder.tv_sizetype.setText(listBean.getSizetype());
        holder.tv_salestate1.setText(listBean.getSalestate());
        return convertView;
    }
    class ViewHolder{
        TextView tv_name,tv_price,tv_sizetype,tv_salestate1;
        ImageView iv_logo1;
    }
}
