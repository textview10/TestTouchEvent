package com.example.administrator.testtouchevent.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.testtouchevent.R;

/**
 * Created by xu.wang
 * Date on  2018/9/17 23:49:32.
 *
 * @Desc    使用ViewDragHelper去测试触摸事件
 *          ViewDragHelper必须收到 ACTION_DOWN才可以执行拖拽逻辑,
 *          所以现在 AView被拖拽到 BViewGroup的上方后,必须松开按下的手指,
 *          再执行一次ACTION_DOWN才可以继续移动.
 */

public class ViewDragHelpActivity extends AppCompatActivity {

    private View aView;
    private ViewGroup bViewGroup, cViewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdragerhelper);
        initialView();
    }

    private void initialView() {
        aView = findViewById(R.id.view_a);
        bViewGroup = findViewById(R.id.viewgroup_b);
        cViewGroup = findViewById(R.id.viewgroup_c);

    }

}
