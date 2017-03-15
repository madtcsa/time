package com.madchen.tomatotime;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.madchen.tomatotime.base.BaseActivity;
import com.madchen.tomatotime.view.BottomView;
import com.madchen.tomatotime.view.CountDownLayoutView;
import com.madchen.tomatotime.view.TopLayoutView;

public class MainActivity extends BaseActivity {

    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = (LinearLayout) findViewById(R.id.root);
        rootView.addView(new TopLayoutView(this),0);
        rootView.addView(new CountDownLayoutView(this),1);
        rootView.addView(new BottomView(this),2);
    }
}
