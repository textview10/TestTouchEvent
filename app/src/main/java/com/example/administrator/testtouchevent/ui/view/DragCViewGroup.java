package com.example.administrator.testtouchevent.ui.view;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by xu.wang
 * Date on  2018/9/17 22:16:32.
 *
 * @Desc
 */

public class DragCViewGroup extends RelativeLayout {
    private static final String TAG = "CViewGroup";
    private ViewDragHelper mHelper;
    private boolean isTop = false;
    private DragBViewGroup dragBViewGroup;

    public DragCViewGroup(Context context) {
        this(context, null);
    }

    public DragCViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragCViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        dragBViewGroup = (DragBViewGroup) getChildAt(0);
    }

    private void initialView() {
        mHelper = ViewDragHelper.create(this, mCallBack);
        mHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_ALL);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (dragerBViewGroup != null && dragerBViewGroup.isTop()) {
//            return true;    //本层消费触摸事件
//        } else {
////            return super.onInterceptTouchEvent(ev);
//            return false; //分发到子View
//        }
        if (ev.getAction() == MotionEvent.ACTION_DOWN && !dragBViewGroup.isTop()){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
            Log.d(TAG, "top = " + top);
            if (top <= 0) {
                isTop = true;
                return 0;
            } else if (top + child.getHeight() >= getHeight()) {    //如果到下边界,就不要再移动了
                isTop = false;
                return getHeight() - child.getHeight();
            } else {
                isTop = false;
                return top;
            }
        }

    };
}
