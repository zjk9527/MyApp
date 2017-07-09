package com.zjk.my_app.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by pjy on 2017/5/10.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public int mSpace;//项间距
    public int left;
    public int right;
    public SpaceItemDecoration(int left, int right, int mSpace){
        this.mSpace=mSpace;
        this.left=left;
        this.right=right;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom=mSpace;
        outRect.left=this.left;
        outRect.right=this.right;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top=mSpace;
        }
    }

}
