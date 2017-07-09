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
import com.zjk.my_app.entity.Pump;

import java.net.URLEncoder;

/**
 * Created by zjk on 2017/5/24.
 */

public class PumpManager {
    //请求
    private static RequestQueue queue=null;
    public  static void loadPump(Context context,
                                    String CityName,
                                    final PumpManager.PumpLoadListener loadListener) {
                try{
                    CityName= URLEncoder.encode(CityName,"utf-8");
                    String url= IURL.ROOT4+"appkey=3e68d2b1348f1c8f&province="+CityName;
                    if (queue==null){
                        queue= Volley.newRequestQueue(context);}
                    StringRequest request=new StringRequest(url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            Gson gson=new Gson();
                            Pump pump=gson.fromJson(s,Pump.class);
                            Log.i("TAG",pump.toString());
                            loadListener.onPumpLoadEnd(pump);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Log.i("TAG:error","error");
                        }
                    });
                    queue.add(request);
                }catch (Exception e){
                    e.printStackTrace();}

    }
    public interface PumpLoadListener{

        void onPumpLoadEnd(Pump pump);
    }
}
