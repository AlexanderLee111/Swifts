package com.alee.swifts;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Circle extends Drawable implements ValueAnimator.AnimatorUpdateListener,Animatable,Drawable.Callback{

    private Camera mCamera;
    private Matrix mMatrix;

    public Circle() {
        mCamera = new Camera();
        mMatrix = new Matrix();
    }

    //Drawable
    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    //Drawable
    @Override
    public void setAlpha(int alpha) {

    }

    //Drawable
    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    //Drawable
    @Override
    public int getOpacity() {
        return 0;
    }

    //AnimatorUpdateListener
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

    }

    //Animatable
    @Override
    public void start() {

    }

    //Animatable
    @Override
    public void stop() {
        
    }

    //Animatable
    @Override
    public boolean isRunning() {
        return false;
    }

    //Drawable.Callback
    @Override
    public void invalidateDrawable(@NonNull Drawable who) {

    }

    //Drawable.Callback
    @Override
    public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {

    }

    @Override
    public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {

    }
}
