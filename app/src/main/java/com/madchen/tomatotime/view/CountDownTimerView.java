package com.madchen.tomatotime.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by chenwei on 06/03/2017.
 */

public class CountDownTimerView extends android.support.v7.widget.AppCompatTextView {

    private CountDownTimer countDownTimer;
    private long durationTimeL;
    private final long updateViewIntervalTimeL = 1000L;

    public CountDownTimerView(Context context, int durationTimeMinutes) {
        super(context);
        this.durationTimeL = minutesTransformToMillisecond(durationTimeMinutes);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initCountDownTimer() {
        this.countDownTimer = new CountDownTimer(durationTimeL, updateViewIntervalTimeL) {
            /**
             * 倒计时过程中，需要定时更新View，如果息屏，应该暂停更新以节省电量和cpu
             * @param millisUntilFinished
             */
            @Override
            public void onTick(long millisUntilFinished) {
                CountDownTimerView.this.setText("");
            }

            @Override
            public void onFinish() {//倒计时结束，需要通知用户

            }
        };
    }

    public void setDurationTimeL(long durationTimeL) {
        this.durationTimeL = durationTimeL;
        //需要更新View的显示
    }

    private long minutesTransformToMillisecond(int minutes) {
        return minutes * 60000L;
    }
}
