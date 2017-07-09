package com.zjk.my_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjk.my_app.R;
import com.zjk.my_app.entity.Weatherbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.zjk.my_app.R.layout.include_weather1;

/**
 * Created by tarena on 2017/5/10.
 */

public class Weather1Adapter extends RecyclerView.Adapter<Weather1Adapter.ViewHolder>{
List<Weatherbean.ResultBean.WeatherBeanX> weatherbeanList=new ArrayList<>();
    private Context context=null;

    public Weather1Adapter(Context context){
        this.context=context;
    }


    /**
     *
     * @param weatherList 天气的数据
     * @param isClear 是否要清空数据
     */
    public void addWeathers(
            List<Weatherbean.ResultBean.WeatherBeanX> weatherList,
            boolean isClear){

        //如果要清空原始数据
        if(isClear){

            this.weatherbeanList.clear();
            this.weatherbeanList.addAll(weatherList);
        }else{
            //不清空原始数据
            this.weatherbeanList.addAll(weatherList);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view= LayoutInflater.from(context).
                inflate(include_weather1,null);
        holder=new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Weatherbean.ResultBean.WeatherBeanX weather=
                weatherbeanList.get(position);
        //获得天气所有状态码
        String conditionNo= weather.getInfo().getDay().get(0);
        if("0".equals(conditionNo)){
            //晴天
            holder.imageView_1.
                    setImageResource(R.drawable.w1);
        }else if("1".equals(conditionNo)){
            //多云
            holder.imageView_1.
                    setImageResource(R.drawable.w2);
        }else if("2".equals(conditionNo)){
            //阴天
            holder.imageView_1.
                    setImageResource(R.drawable.w3);
            //阵雨
        }else if ("3".equals(conditionNo)){
            holder.imageView_1.
                    setImageResource(R.drawable.w4);
        }else if ("4".equals(conditionNo)){
            holder.imageView_1.
                    setImageResource(R.drawable.w5);
        }else if ("5".equals(conditionNo)){
            holder.imageView_1.
                    setImageResource(R.drawable.w6);
        }else if ("6".equals(conditionNo)){
            holder.imageView_1.
                    setImageResource(R.drawable.w7);
        }else if ("7".equals(conditionNo)){
            holder.imageView_1.
                    setImageResource(R.drawable.w8);
        }else {
            holder.imageView_1.setImageResource(R.drawable.w2);
        }

        holder.tv_weather1.setText(weather.getInfo().getDay().get(1));
        holder.tv_weather2.setText(
                weather.getInfo().getNight().get(2) +
                        "/"+weather.getInfo().getDay().get(2));
        holder.tv_weather3.setText("星期"+weather.getWeek());
        holder.tv_wind.setText(weather.getInfo().getDay().get(4));
    }

    @Override
    public int getItemCount() {

        return this.weatherbeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_1;//天气状态的图片
        TextView tv_weather1;//晴天/阴天...
        TextView tv_weather2;//最高气温和最低气温
        TextView tv_weather3;//星期几
        TextView tv_wind;//风
        public ViewHolder(View itemView) {
            super(itemView);
            imageView_1= (ImageView) itemView.findViewById(R.id.imageView_1);
            tv_weather1= (TextView) itemView.findViewById(R.id.tv_weather1);
            tv_weather2= (TextView) itemView.findViewById(R.id.tv_weather2);
            tv_weather3= (TextView) itemView.findViewById(R.id.tv_weather3);
            tv_wind= (TextView) itemView.findViewById(R.id.tv_wind);

        }
    }
}
