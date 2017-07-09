package com.zjk.my_app.util;

import android.content.Context;
import android.content.res.Resources;


public class DisplayUtil {
    public static  int dp2px(Context context,int dp)
    {
        Resources resources=context.getResources();
        //scale缩放
        //Density 密度
        float density=resources.getDisplayMetrics().scaledDensity;
        float px=dp*density;
        //px 10.9+0.5=11.4=11
        //10.4+0.5=10.9=10
        return (int)(px+0.5);
    }
}
