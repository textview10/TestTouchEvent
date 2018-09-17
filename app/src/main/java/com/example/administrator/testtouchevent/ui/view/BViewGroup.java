package com.example.administrator.testtouchevent.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/9/17/017.
 */

public class BViewGroup extends RelativeLayout {
    public BViewGroup(Context context) {
        this(context,null);
    }

    public BViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialView();
    }

    private void initialView() {

    }
}
