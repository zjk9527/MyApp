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
import com.zjk.my_app.entity.Weather;


import java.net.URLEncoder;

/**
 * Created by zjk on 2017/5/15.
 */

public class WeatherManager {
    //
    private static RequestQueue queue=null;
   public  static void loadWeather(Context context,
                                   String CityName,
                                   final WeathirLoadListener loadListener){
       try{
           CityName= URLEncoder.encode(CityName,"utf-8");
          String url= IURL.ROOT1+"cityname=武汉&dtype=&format=&key=fb299080f4f7bde04022443327e3bb93";
if (queue==null){
    queue= Volley.newRequestQueue(context);
}
           StringRequest request=new StringRequest(url, new Response.Listener<String>() {
               @Override
               public void onResponse(String s) {
                   Gson gson=new Gson();
                   Weather weather=gson.fromJson(s,Weather.class);
                   Log.i("TAG",weather.toString());
                   loadListener.onWeatherLoadEnd(weather);
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError volleyError) {
                   Log.i("TAG:error","error");
               }
           });
           queue.add(request);
       }catch (Exception e){
           e.printStackTrace();
       }

   }
    public interface WeathirLoadListener{

    void onWeatherLoadEnd(Weather weather);
}
}
