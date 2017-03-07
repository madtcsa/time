package com.madchen.tomatotime.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.madchen.tomatotime.R;
import com.madchen.tomatotime.constants.Constants;

/**
 * Created by chenwei on 06/03/2017.
 */

public class CountDownLayoutView extends LinearLayout {

    private Context context;

    public CountDownLayoutView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public CountDownLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CountDownLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.countdown_layout, null);
        CountDownTimerView countDownTimerView = new CountDownTimerView(context, Constants.DEFAULT_MINUTES);
        addView(countDownTimerView,0);
    }
}
