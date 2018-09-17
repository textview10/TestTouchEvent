package com.example.administrator.testtouchevent.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/9/17/017.
 */

public class CViewGroup extends RelativeLayout {
    public CViewGroup(Context context) {
        this(context,null);
    }

    public CViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
