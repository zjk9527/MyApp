package com.zjk.my_app.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;



import java.util.List;



/**
 * Created by zjk on 2017/4/22.
 */
public class MyAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> imageViews;
    public MyAdapter(Context context, List<ImageView> imageViews){
        this.context=context;
        this.imageViews=imageViews;
    }



    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView iv=imageViews.get(position);
        container.addView(iv);
        iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position+"",Toast. LENGTH_SHORT).show();
            }
        });
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1 ;
    }
}
