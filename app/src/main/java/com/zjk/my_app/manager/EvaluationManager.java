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
import com.zjk.my_app.entity.Evaluation;

import java.lang.ref.ReferenceQueue;

/**
 * Created by zjk on 2017/5/20.
 */

public class EvaluationManager {
            private static RequestQueue queue=null;
    public static EvaluationLoadListener mListener;
    public static void loadEvaluation(Context context){
        try {
            String url= IURL.ROOT3+"type=qiche&key=1547f19a96b36948ec56f741bbcec4d0";
            if (queue==null){
                queue= Volley.newRequestQueue(context);
            }
            Log.i("TAG", "获取到的看看url="+url);
            StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Gson gson=new Gson();
                    Evaluation evaluation=gson.fromJson(s,Evaluation.class);
                    mListener.onevaluationLoadEnd(evaluation);


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


public interface EvaluationLoadListener{

    void onevaluationLoadEnd(Evaluation evaluation);
}
    public static void loadEvaluation(Context context,EvaluationLoadListener loadListener){
        loadEvaluation(context);
        mListener=loadListener;
    }
}
