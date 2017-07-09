package com.zjk.my_app.util;

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

public class IdmodelManager {
    private static RequestQueue queue=null;

   public static IdmodelLoadListener mListener1;
public static void loadIdmodel(Context context,String path1){
    try{
        String url1=IURL.ROOT7+"appkey=3e68d2b1348f1c8f&parentid="+path1;
        if (queue==null){
            queue=Volley.newRequestQueue(context);
        }
        StringRequest request=new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                IdModel idModel=gson.fromJson(s,IdModel.class);
                mListener1.onidmodelLoadEnd(idModel);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("TAG1", "响应失败"+volleyError.getMessage());
            }
        });
        queue.add(request);
    }catch (Exception e){e.printStackTrace();}
}
   

    public interface IdmodelLoadListener{

        void onidmodelLoadEnd(IdModel idModel);
    }
    public static void loadIdmodel(Context context,String path1,IdmodelLoadListener loadListener1){
        loadIdmodel(context,path1);
        mListener1=loadListener1;
    }
}
