package com.example.administrator.testtouchevent.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;

/**
 * Created by xu.wang
 * Date on  2018/9/17 23:42:32.
 *
 * @Desc
 */

public class AView extends View {
    private float lastX, lastY = -1;
    private float mTouchSLop;
    private Scroller mScroller;

    public AView(Context context) {
        this(context, null);
    }

    public AView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialView();
    }

    private void initialView() {
        mScroller = new Scroller(getContext());
        mTouchSLop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (lastX != -1 && lastY != -1) {
            float dX = event.getX() - lastX;
            float dY = event.getY() - lastY;
//            if ()
        }
        lastX = event.getX();
        lastY = event.getY();
        return super.onTouchEvent(event);

    }
}
