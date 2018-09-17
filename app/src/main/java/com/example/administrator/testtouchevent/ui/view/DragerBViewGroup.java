package com.example.administrator.testtouchevent.ui.view;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by xu.wang on 2018/9/17 22:05.
 */

public class DragerBViewGroup extends RelativeLayout {
    private static final String TAG = "BViewGroup";
    private boolean isTop = false;  //是否到达顶部

    private ViewDragHelper mHelper;

    public DragerBViewGroup(Context context) {
        this(context, null);
    }

    public DragerBViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragerBViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialView();
    }

    private void initialView() {
        mHelper = ViewDragHelper.create(this, mCallBack);
        mHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_ALL);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isTop){
            Log.e(TAG,"request false" );
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            Log.e(TAG,"request true");
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        mHelper.processTouchEvent(event);
        return true;
    }

    ViewDragHelper.Callback mCallBack = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            if (top <= 0) {
                isTop = true;
                return 0;
            } else if (top + child.getHeight() >= getHeight()) {
                isTop = false;
                return getHeight() - child.getHeight();
            } else {
                isTop = false;
                return top;
            }
        }

    };

    public boolean isTop() {
        return isTop;
    }
}
