package com.example.point_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @Description: Created by JAtank on 2017/1/18.
 */

public class PointView extends View {
    private int pointNum;
    private int mCurrentPosition;
    private int width;
    private int height;
    private int distance;
    private String mCurColor;
    private String mPointColor;

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i = 0; i< pointNum;i++){
            distance = (width/pointNum)*i;
            if (i == mCurrentPosition){
                paint.setColor(Color.parseColor("#DD4C3F"));
            }else {
                paint.setColor(Color.parseColor("#888888"));
            }
            canvas.drawCircle(width/(2*pointNum)+distance,height/2,Math.min(width/(2*pointNum),height/2),paint);
        }
        Log.e("point",width+"++++++++++"+height+"------"+pointNum+"*******"+mCurrentPosition);
    }

    /**
     * 设置点的个数
     * @param num
     */
    public void setPointNum(int num){
        this.pointNum = num ;
        invalidate();
    }

    /**
     * 设置当前点的位置
     * @param currentPosition
     */
    public void setCurrentPosition(int currentPosition){
        this.mCurrentPosition = currentPosition;
        invalidate();
    }

    /**
     * 设置当前点的颜色
     * @param color
     */
    public void setCurrentColor(String color){
        this.mCurColor = color;
    }

    /**
     * 设定非当前点的颜色
     * @param color
     */
    public void setPointColor(String color){
         this.mPointColor = color;
    }
}
