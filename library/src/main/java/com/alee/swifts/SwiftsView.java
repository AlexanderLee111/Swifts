package com.alee.swifts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;


public class SwiftsView extends ProgressBar {

    private Style mStyle;

    public SwiftsView(Context context) {
        super(context);
    }

    public SwiftsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwiftsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SwiftsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
