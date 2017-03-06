package com.madchen.tomatotime.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenwei on 06/03/2017.
 */

public class CountDownLayoutView extends View {

    private Context context;

    public CountDownLayoutView(Context context) {
        super(context);
        this.context = context;
    }

    public CountDownLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {

    }
}
