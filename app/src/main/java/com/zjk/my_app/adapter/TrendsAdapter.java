package com.zjk.my_app.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.zjk.my_app.R;
import com.zjk.my_app.app_activity.DialogueActivity;
import com.zjk.my_app.entity.Trends;
import com.zjk.my_app.util.CircleImageView;
import com.zjk.my_app.util.ToastUtils;


import java.util.List;


public class TrendsAdapter extends BaseAdapter {
    private Context context;
    private List<Trends> list;
    private ViewHolder holder;


    public TrendsAdapter(Context context, List<Trends> list) {
        this.context = context;
        this.list = list;

    }
/*
    int num=5;
    public void setNumber(){
        num+=5;
    }*/
    @Override
    public int getCount(){
        return list.size();
        /*num>list.size()?list.size():num;*/
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
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.include_content, null);
            holder = new ViewHolder();
            holder.avatar = (CircleImageView) convertView.findViewById(R.id.iv_avatar);//头像
            holder.author = (TextView) convertView.findViewById(R.id.tv_author);//名字
            holder.img = (ImageView) convertView.findViewById(R.id.iv_img);//待上传的图片
            holder.content = (TextView) convertView.findViewById(R.id.tv_content);//待上传的文本
            holder.comment = (TextView) convertView.findViewById(R.id.tv_comment);//评论
            holder.dialogue = (TextView) convertView.findViewById(R.id.tv_dialogue);//会话
            holder.createdTime = (TextView) convertView.findViewById(R.id.tv_created_time);//当前时间
            holder.phone = (TextView) convertView.findViewById(R.id.tv_phone);//联系方式（手机号码）
            holder.img_isSort = (ImageView) convertView.findViewById(R.id.img_isSort);//类别（个人，修理工）
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Trends trends = list.get(position);

        if ("汽修工".equals(trends.getClasses())) {

            holder.img_isSort.setImageResource(R.drawable.repairman);
        } else {
            if ("个人".equals(trends.getClasses())) {
                Log.i("TAG", "你赢了");
                holder.img_isSort.setImageResource(R.drawable.person);
            }
        }
        if (trends.getAuthor().getAvatar() != null) {
            Glide.with(context)
                    .load(trends.getAuthor().getAvatar().getFileUrl())
                    .into(holder.avatar);
        } else {
            Glide.with(context)
                    .load(R.drawable.default_avatar)
                    .into(holder.avatar);
        }
        holder.author.setText(trends.getAuthor().getName());
        if (trends.getImg() != null) {
            holder.img.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(trends.getImg().getFileUrl())
                    .into(holder.img);
        } else {
            holder.img.setVisibility(View.GONE);
        }


        holder.phone.setText(trends.getPhone());
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view.findViewById(R.id.tv_phone);
                String str = textView.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str));
                if (ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                context.startActivity(intent);
            }
        });
        //点击会话控件
        final View finalConvertView = convertView;
        holder.dialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(finalConvertView.getContext(), DialogueActivity.class));
                ToastUtils.showLong(context,"该功能正在开发中...");
            }
        });
        //点击评论控件
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLong(context,"该功能正在开发中...");
            }
        });
        holder.content.setText(trends.getContent());
        holder.createdTime.setText(trends.getCreatedAt());

        return convertView;
    }
    private class ViewHolder {
        CircleImageView avatar; // 头像
        TextView author; // 作者
        ImageView img,img_isSort; // 图片
        TextView content; // 内容
        TextView createdTime,phone,comment,dialogue; // 创建时间，手机号码 评论 会话
    }

}
