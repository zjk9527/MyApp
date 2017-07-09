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
import com.zjk.my_app.entity.IdModel;
import com.zjk.my_app.entity.Model;

/**
 * Created by zjk on 2017/6/1.
 */

public class ModelManager {
    private static RequestQueue queue=null;
    public static ModelLoadListener mListener;


    public  static void loadModel(Context context,String path){
        try{
            String url= IURL.ROOT6+"appkey=3e68d2b1348f1c8f&parentid="+path;
            if (queue==null){
                queue= Volley.newRequestQueue(context);
            }
            Log.i("TAG1","uri="+url);
            StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Gson gson=new Gson();
                    Model model=gson.fromJson(s,Model.class);
                    mListener.onmodelLoadEnd(model);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.i("TAG1", "响应失败"+volleyError.getMessage());
                }
            });
          queue.add(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   

    public interface ModelLoadListener{

        void onmodelLoadEnd(Model model);
    }
    public static void loadModel(Context context,String path,ModelLoadListener loadListener){
        loadModel(context,path);
        mListener=loadListener;
    }

}
