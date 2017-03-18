package com.madchen.tomatotime.customview;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.madchen.tomatotime.R;
import com.madchen.tomatotime.model.Tomato;

/**
 * Created by chenwei on 18/03/2017.
 */

public class TomatoView extends LinearLayout {

    private Context mContext;
    private Tomato mTomato;
    private TextView startTv, timeText;
    private CountDownTimer mCountDownTimer;
    private boolean isCountDowning = false;
    private TomatoStatusListener mTomatoStatusListener;

    public TomatoView(Context context) {
        this(context, null);
    }

    public TomatoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TomatoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initLayout();
    }

    private void initLayout() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.countdown_layout, this);
        addView(view);
        timeText = (TextView) view.findViewById(R.id.text_time);
        startTv = (TextView) view.findViewById(R.id.btn_start_count_down);
    }

    public Tomato getTomato() {
        return mTomato;
    }

    public void setTomato(Tomato tomato) {
        mTomato = tomato;
    }

    public void startTomato() {
        isCountDowning = true;
        mCountDownTimer = new CountDownTimer(System.currentTimeMillis()+mTomato.getTotalTimeL(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTomato.setSecond(mTomato.getSecond() - 1);
                if (mTomato.getSecond() == -1) {
                    mTomato.setMinutes(mTomato.getMinutes() - 1);
                    if (mTomato.getMinutes() == -1) {
                        //finish one Tomato
                        mTomatoStatusListener.finishTomato();
                        this.cancel();
                        return;
                    } else {
                        mTomato.setSecond(59);
                    }
                }
                String time = (mTomato.getMinutes() >= 10 ? "" + mTomato.getMinutes() : "0" + mTomato.getMinutes())
                        + " : " + (mTomato.getSecond() >= 10 ? mTomato.getMinutes() : "0" + mTomato.getSecond());
                timeText.setText(time);
            }

            @Override
            public void onFinish() {
                // open finish dialog
                mTomatoStatusListener.finishTomato();
            }
        };
        startTv.setText(R.string.cancel_tomato_time);
    }

    public boolean isCountDowning() {
        return isCountDowning;
    }

    public void cancelTomato() {
        isCountDowning = false;
        mCountDownTimer.cancel();
        startTv.setText(R.string.start_count_down);
        timeText.setText(R.string.default_tomato_time);
    }

    public interface TomatoStatusListener {

        void finishTomato();
    }

    public void setTomatoStatusListener(TomatoStatusListener tomatoStatusListener) {
        mTomatoStatusListener = tomatoStatusListener;
    }

    public void overTomato() {
        cancelTomato();
    }
}
