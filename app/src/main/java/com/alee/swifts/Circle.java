package com.alee.swifts;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Circle extends Drawable implements Animatable, Drawable.Callback {

    private Paint paint;
    private int boundWidth;
    private int boundHeight;
    private int mRadius;

    private ObjectAnimator animator;

    public Circle() {
        paint = new Paint();
        paint.setAntiAlias(true);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(boundWidth / 2, boundHeight / 2, mRadius, paint);
    }

    Property<Circle, Integer> mRadiusProperty = new Property<Circle, Integer>(Integer.class, "radius") {
        @Override
        public void set(Circle object, Integer value) {
            object.setRadius(value);
        }

        @Override
        public Integer get(Circle object) {
            return object.getRadius();
        }
    };

    public int getRadius() {
        return mRadius;
    }

    public void setRadius(int radius) {
        mRadius = radius;
    }


    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);

        if (isRunning()) {
            stop();
        }


        boundWidth = bounds.width();
        boundHeight = bounds.height();

        mRadius = Math.min(boundHeight / 2, boundWidth / 2) - 50;


        // 控制扩散半径的属性变化
        PropertyValuesHolder radiusHolder = PropertyValuesHolder.ofInt(mRadiusProperty, 0, mRadius);
        // 控制透明度的属性变化
        PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofInt("alpha", 255, 0);

        animator = ObjectAnimator.ofPropertyValuesHolder(this, radiusHolder, alphaHolder);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidateSelf();
            }
        });
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        Log.d("XXXX", "setAlpha: " + alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }


    @Override
    public void start() {
//        if (animator != null && !animator.isRunning()) {
//            animator.start();
//        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return animator != null && animator.isRunning();

    }

    @Override
    public void invalidateDrawable(@NonNull Drawable who) {
        invalidateSelf();
    }

    @Override
    public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {

    }

    @Override
    public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {

    }


}
