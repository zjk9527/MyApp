package com.zjk.my_app.manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zjk.my_app.constant.IURL;
import com.zjk.my_app.entity.Weatherbean;

import java.net.URLEncoder;


/**
 * Created by tarena on 2017/5/10.
 */

public class HttpWeatherManager {
    //请求队列
    public static RequestQueue queue=null;
    /**
     *
     * @param context 上下文对象
     * @param
     * @param loadListener 加载完毕的监听器接口
     */
    public static void loadWeather(Context context, String CityName,
            final WeatherLoadListener loadListener){
        try {
            CityName = URLEncoder.encode(CityName, "utf8");
            String url = IURL.ROOT8 + "key=1c98314f3e864884a3d60288c6b84e55&cityname="+CityName;
            // String url="http://176.216.1.225:8080/WeatherServer/weather.jsp";

            if (queue == null) {
                queue = Volley.newRequestQueue(context);
            }
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Gson gson = new Gson();
                    Weatherbean weatherbean = gson.fromJson(s, Weatherbean.class);
                    Log.i("TAG:weather", weatherbean.toString());
                    loadListener.onWeatherLoadEnd(weatherbean);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.i("TAG:error", "error");
                }
            });
            //将请求对象添加到请求队列中
            queue.add(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public interface WeatherLoadListener{
        public void onWeatherLoadEnd(Weatherbean weatherbean);
    }
}
