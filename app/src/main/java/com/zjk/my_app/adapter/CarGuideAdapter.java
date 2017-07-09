package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.CarGuide;
import com.zjk.my_app.fragment.ImageHelper;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 *   导购界面
 * Created by zjk on 2017/5/20.
 */

public class CarGuideAdapter extends BaseAdapter{
    List<CarGuide.ResultBean.ListBean>carGuideList=new ArrayList<>();
    private Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    private ImageHelper imageHelper=new ImageHelper(context);
    public CarGuideAdapter(Context context){
        this.context=context;
    }
    public void addcarGuide(List<CarGuide.ResultBean.ListBean>carGuideLists,boolean isClear){
        if (isClear){
            this.carGuideList.clear();
            this.carGuideList.addAll(carGuideLists);
        }else{
            //不清空数据
            this.carGuideList.addAll(0,carGuideLists);
        }
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return carGuideList.size();
    }

    @Override
    public CarGuide.ResultBean.ListBean getItem(int position) {
        return carGuideList.get(position);
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
            convertView=View.inflate(context, R.layout.inlcude_carguide,null);
            holder.iv_imgurl= (ImageView) convertView.findViewById(R.id.iv_imgurl);
            holder.tv_carguide_title= (TextView) convertView.findViewById(R.id.tv_carguide_title);
            holder.tv_Iastreplydate= (TextView) convertView.findViewById(R.id.tv_Iastreplydate);
            holder.bbsname= (TextView) convertView.findViewById(R.id.bbsname);
            holder.postusername= (TextView) convertView.findViewById(R.id.postusername);
            holder.tv_replycount= (TextView) convertView.findViewById(R.id.tv_replycount);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        CarGuide.ResultBean.ListBean listBean=carGuideList.get(position);
        String imagerUri=listBean.getImgurl();
        imageHelper.display(holder.iv_imgurl,imagerUri);
        holder.tv_carguide_title.setText(listBean.getTitle());
        holder.tv_Iastreplydate.setText(listBean.getLastreplydate());
        holder.bbsname.setText(listBean.getBbsname());
        holder.postusername.setText(listBean.getPostusername());
        holder.tv_replycount.setText(listBean.getReplycounts()+"个评论");
        return convertView;
    }
    public class ViewHolder{
        ImageView iv_imgurl;    //图片
        TextView tv_carguide_title;   //主题
        TextView tv_Iastreplydate; //更新日
        TextView bbsname;//出处
        TextView postusername;//zuoz
        TextView tv_replycount; //回帖数

    }
}
