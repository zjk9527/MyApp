package com.zjk.my_app.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.utils.L;
import com.zjk.my_app.constant.IURL;
import com.zjk.my_app.entity.News_zuixin;
import com.zjk.my_app.util.StreamUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjk on 2017/5/3.
 */

public class NewsZuixinManager {
    //请求队列
    private static RequestQueue queue = null;
    private static News_zuixinLoadListener mListener;

    private static void loadNews(Context context) {
        try {
            String url = IURL.ROOT+"newslist-a2-pm2-v3.2.0-c0-nt0-p1-s20-l0.html";
            if (queue == null) {
                queue = Volley.newRequestQueue(context);
            }
            Log.i("TAG", "url="+url);
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Log.i("TAG", "s="+s);
                    Gson gson = new Gson();
                    News_zuixin news_zuixin = gson.fromJson(s,News_zuixin.class);
                    Log.i("TAG:1", news_zuixin.toString());
                    mListener.onnewLoadEnd(news_zuixin);
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.i("TAG", "响应失败"+volleyError.getMessage());
                }
            });
            queue.add(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      /*
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setDoInput(true);
        InputStream inputStream=httpURLConnection.getInputStream();
        String json=StreamUtil.getStrFromStream(inputStream);
        News_zuixin news_zuixin =gson.fromJson(json,News_zuixin.class);
Log.i("TAG:news_zuixin看看",news_zuixin.toString());
        queue.add()
        return news_zuixin;
    }*/


    public interface News_zuixinLoadListener {
        void onnewLoadEnd(News_zuixin news_zuixin);
    }
    public static void loadnews(Context context,News_zuixinLoadListener loadListener){
        loadNews(context);
        mListener=loadListener;

    }


}


























    /*public static void loadNew(Context context,final News_zuixinLoadListener loadListene){
        try{
            String url=IURL.ROOT+"news/newslist-a2-pm2-v3.2.0-c0-nt0-p1-s20-l0.htm";
            if (queue==null){
                queue= Volley.newRequestQueue(context);
            }
            StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Gson gson=new Gson();
                    News_zuixin news_zuixin=gson.fromJson(s,News_zuixin.class);
                    Log.i("TAG:newzuixin",news_zuixin.toString());
                    loadListene.onnewLoadEnd(news_zuixin);
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
        }*/






