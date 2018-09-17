package com.example.administrator.testtouchevent.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.testtouchevent.R;

/**
 * Created by xu.wang on 2018/9/17/ 23:17.
 */

public class TestTouchEventActivity extends AppCompatActivity {
    private View aView;
    private ViewGroup bViewGroup, cViewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_touchevent);
        initialView();
    }
    private void initialView() {
        aView = findViewById(R.id.view_a);
        bViewGroup = findViewById(R.id.viewgroup_b);
        cViewGroup = findViewById(R.id.viewgroup_c);


    }
}
