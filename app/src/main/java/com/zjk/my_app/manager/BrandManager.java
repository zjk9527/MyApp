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
import com.zjk.my_app.entity.Brand;

import java.lang.ref.ReferenceQueue;

/**
 * Created by zjk on 2017/5/25.
 */

public class BrandManager {
    private static RequestQueue queue=null;
    public static BrandLoadListener mListener;
    public static void loadBrand(Context context){
        try{
            String url= IURL.ROOT5+"appkey=3e68d2b1348f1c8f";
            if (queue==null){
                queue= Volley.newRequestQueue(context);
            }
            StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Gson gson=new Gson();
                    Brand brand=gson.fromJson(s,Brand.class);
                    mListener.onbrandLoadEnd(brand);
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
    public interface BrandLoadListener{
        void onbrandLoadEnd(Brand brand);
    }
    public static void loadBrand(Context context,BrandLoadListener loadListener){
        loadBrand(context);
        mListener=loadListener;
    }
}
