package com.kulkarniameya.customnotepad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

/**
 * Created by ameya on 7/5/16.
 */
public class Notepad extends EditText {
    private Paint mPaint;


    public Notepad(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK);
        setGravity(Gravity.TOP);
        setGravity(Gravity.LEFT);
        setBackgroundColor(Color.parseColor("#00000000"));

    }

    public Notepad(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK);
        setGravity(Gravity.TOP);
        setGravity(Gravity.LEFT);
        setBackgroundColor(Color.parseColor("#00000000"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight();

        int line_height = getLineHeight();

        int count = height / line_height;

        if (getLineCount() > count) {
            count = getLineCount();
        }



        Rect r = new Rect();
        Paint paint = mPaint;
        int baseline = getLineBounds(0, r);
        for (int i = 0; i < count; i++) {
            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            baseline += getLineHeight();
        }
        super.onDraw(canvas);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Try for a width based on our minimum
        int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 1);

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        int minh = MeasureSpec.getSize(w) + getPaddingBottom() + getPaddingTop();
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);
        setMeasuredDimension(w, h);
    }


}
