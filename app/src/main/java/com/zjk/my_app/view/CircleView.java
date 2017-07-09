package com.zjk.my_app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zjk on 2017/4/22.
 */

public class CircleView extends View {
    //画笔(并增加看锯齿)
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    private int strokeStartPos;//声明圆的位置
    float fillStartPos;
    private  int height;//高度
    private  int radius=10;//圆的半径


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        fillStartPos=strokeStartPos=w/2-5*radius;//圆和圆的间距
        height=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);//画笔为空心
        paint.setStrokeWidth(2);//画笔宽度（dp）
        paint.setColor(Color.BLACK);//颜色
        //绘制圆
        for (int i=0;i<5;i++){
            canvas.drawCircle(strokeStartPos+i*3*radius,height/2,radius,paint);
        }
        //绘制空心里面的实心圆
        paint.setStyle(Paint.Style.FILL);//实心
        paint.setColor(Color.BLUE);
        canvas.drawCircle(fillStartPos,height/2,radius-4,paint);
    }
    public void change(int position, float offset){
        fillStartPos=strokeStartPos+(position+offset)*radius*3;
        invalidate();
    }
}
