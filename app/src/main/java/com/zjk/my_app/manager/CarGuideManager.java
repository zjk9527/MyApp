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
import com.zjk.my_app.entity.CarGuide;


/**
 * Created by zjk on 2017/5/20.
 */

public class CarGuideManager {
    //请求
    private static RequestQueue queue=null;
    private static CarGuideLoadListener mListener;
    private static void loadCarGuide(Context context){
        try{
            String url= IURL.ROOT2+"jinghuahome-a2-pm2-v3.2.0-p1-s20.html";
            if (queue==null){
                queue= Volley.newRequestQueue(context);
            }
            Log.i("TAG8", "获取到的看看url="+url);
            StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Log.i("TAG", "能不能得到s"+s);
                    Gson gson=new Gson();
                    CarGuide carGuide=gson.fromJson(s,CarGuide.class);
                    mListener.oncarguideLoadEnd(carGuide);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.i("TAG", "响应失败"+volleyError.getMessage());
                }
            });
           queue.add(request);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  interface CarGuideLoadListener{
        void oncarguideLoadEnd(CarGuide carGuide);
    }
    public static void loadcarGuide(Context context,CarGuideLoadListener loadListener){
        loadCarGuide(context);
        mListener=loadListener;
    }
}
