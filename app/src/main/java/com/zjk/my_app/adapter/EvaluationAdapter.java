package com.zjk.my_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.Evaluation;
import com.zjk.my_app.fragment.ImageHelper;
import com.zjk.my_app.imager.MyBitmapUtils;
import com.zjk.my_app.manager.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 *     评测界面
 *
 * Created by zjk on 2017/5/20.
 * Evaluation   评测
 */

public class EvaluationAdapter extends BaseAdapter {
    List<Evaluation.ResultBean.DataBean>evaluationList=new ArrayList<>();
    private Context context;
    private MyBitmapUtils utils=new MyBitmapUtils();
    private ImageHelper imageHelper=new ImageHelper(context);
    public  EvaluationAdapter(Context context){
        this.context=context;
    }
    public void addevaluation(List<Evaluation.ResultBean.DataBean>
                                      evaluationLists,boolean isClear){
        if (isClear){
            this.evaluationList.clear();
            this.evaluationList.addAll(5, evaluationLists);
        }else{
            //不清空数据
            this.evaluationList.addAll(0,evaluationLists);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return evaluationList.size();
    }

    @Override
    public Evaluation.ResultBean.DataBean getItem(int position) {
        return evaluationList.get(position);
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
            convertView=View.inflate(context, R.layout.inlcude_evaluation,null);
            holder.iv_thumbnail_pic_s= (ImageView) convertView.findViewById(R.id.iv_thumbnail_pic_s);
            holder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_date= (TextView) convertView.findViewById(R.id.tv_date);
            holder.tv_author_name= (TextView) convertView.findViewById(R.id.tv_author_name);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Evaluation.ResultBean.DataBean dataBean=evaluationList.get(position);
        String imagerUri=dataBean.getThumbnail_pic_s();
       imageHelper.display(holder.iv_thumbnail_pic_s,imagerUri);
        holder.tv_title.setText(dataBean.getTitle());
        holder.tv_date.setText(dataBean.getDate());
        holder.tv_author_name.setText(dataBean.getAuthor_name());

        return convertView;
    }
    public class ViewHolder{
        ImageView iv_thumbnail_pic_s;
        TextView tv_title;
        TextView tv_date;
        TextView tv_author_name;

    }
}
