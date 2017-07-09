package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.Picture;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/6.
 *
 *           我的界面的功能区 适配器
 *
 *
 */


public class PictureAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    //图片和文字的集合
    private List<com.zjk.my_app.entity.Picture> pictures ;

public PictureAdapter(String[] titles, int[] images, Context context){
    super();
    pictures=new ArrayList<>();
    inflater = LayoutInflater.from(context);
    for (int i=0; i<images.length;i++){
        Picture picture = new Picture(titles[i],images[i]);
        pictures.add(picture);
    }
}




    @Override
    public int getCount() {
        if (null!=pictures){
            return  pictures.size();
        }else{
        return 0;
    }}

    @Override
    public Object getItem(int position) {
        return 0 /*pictures.get(position)*/;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView=inflater.inflate(R.layout.inluude_funcyion,null);
            viewHolder=new ViewHolder();
            viewHolder.title= (TextView) convertView.findViewById(R.id.textView_title);
            viewHolder.image= (ImageView) convertView.findViewById(R.id.imageView_images);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(pictures.get(position).getTitle());
        viewHolder.image.setImageResource(pictures.get(position).getImageId());
        return convertView;
    }
class ViewHolder {
    public TextView title;
    public ImageView image;

}

}
