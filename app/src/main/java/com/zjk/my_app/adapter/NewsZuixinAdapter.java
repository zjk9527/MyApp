package com.zjk.my_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.zjk.my_app.R;
import com.zjk.my_app.entity.News_zuixin;
import com.zjk.my_app.fragment.ImageHelper;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/11.
 * 资讯  最新
 */

public class NewsZuixinAdapter extends BaseAdapter {
    List<News_zuixin.ResultBean.NewslistBean> newsList = new ArrayList<>();
    private Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    private ImageHelper imageHelper=new ImageHelper(context);
    public NewsZuixinAdapter(Context context) {
        this.context = context;
    }
public void addNews(List<News_zuixin.ResultBean.NewslistBean> newsLists ,boolean isClear){
    if (isClear){
        this.newsList.clear();
        this.newsList.addAll(newsLists);
    }else{
        this.newsList.addAll(0,newsLists);

    }
    notifyDataSetChanged();
}

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public News_zuixin.ResultBean.NewslistBean getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.inlcude_news_zuixin,null);
            holder.iv_smallpic= (ImageView) convertView.findViewById(R.id.iv_smallpic);
            holder.tv_news_title= (TextView) convertView.findViewById(R.id.tv_news_title);
            holder.tv_news_time= (TextView) convertView.findViewById(R.id.tv_news_time);
            holder.tv_replycount= (TextView) convertView.findViewById(R.id.tv_replycount);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        News_zuixin.ResultBean.NewslistBean newslistBean= newsList.get(position);

        String imagerUri= newslistBean.getSmallpic();
        Log.i("TAG:0",imagerUri);
      imageHelper.display(holder.iv_smallpic,imagerUri);

        holder.tv_news_title.setText(newslistBean.getTitle());
        holder.tv_news_time.setText(newslistBean.getTime());
        holder.tv_replycount.setText(newslistBean.getReplycount()+""+"个评论");

        return convertView;
    }
    public class ViewHolder {
        ImageView iv_smallpic;//新闻图片
        TextView tv_news_title;//新闻主题
        TextView tv_news_time;//更新时间
        TextView tv_replycount;//评论数

    }
}


