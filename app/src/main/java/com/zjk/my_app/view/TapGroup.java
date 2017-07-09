package com.zjk.my_app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/**
 * Created by zjk on 2017/4/22.
 */

public class TapGroup extends RadioGroup {
    public TapGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TapGroup(Context context) {
        super(context);
    }
    private int redLineStart;
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    /**绘制View的子元素时执行*/
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //1.保存原有绘制状态
        canvas.save();
        //2.绘制新的内容
        //2.1绘制一条灰色线
        Path path=new Path();
        path.moveTo(0, getHeight());
        path.lineTo(getWidth(),getHeight());
        paint.setStyle(Paint.Style.STROKE);//绘制线时一定要这样设置样式
        paint.setStrokeWidth(2);
        paint.setColor(Color.GRAY);//灰色
        canvas.drawPath(path, paint);
        //2.2绘制一条红色线
        path=new Path();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        path.moveTo(redLineStart, getHeight());
        path.lineTo(redLineStart+getWidth()/getChildCount(), getHeight());
        canvas.drawPath(path, paint);
        //3.恢复绘制状态
        canvas.restore();
    }
    public void updateDraw(int position){
        redLineStart=
                position*(
                        getWidth()/getChildCount());
        //执行此方法时会重新执行onDraw，dispatchDraw方法
        invalidate();
    }

}
