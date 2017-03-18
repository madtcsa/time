package com.madchen.tomatotime;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.madchen.tomatotime.base.BaseActivity;
import com.madchen.tomatotime.countdown.CountDownPresenter;
import com.madchen.tomatotime.countdown.CountDownPresenterImpl;
import com.madchen.tomatotime.countdown.CountDownView;
import com.madchen.tomatotime.customview.TomatoView;
import com.madchen.tomatotime.model.Tomato;

public class MainActivity extends BaseActivity implements CountDownView, View.OnClickListener, TomatoView.TomatoStatusListener {

    private LinearLayout rootView;
    private CountDownPresenter mPresenter;
    private TomatoView mTomatoView;
    private TextView myDataText, settingText, musicText, totalMinutesText,
            totalHoursText, helpText, startText, timeText;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mPresenter = new CountDownPresenterImpl(this);
        initView();
    }

    private void initView() {
        rootView = (LinearLayout) findViewById(R.id.root);
        mTomatoView = (TomatoView) findViewById(R.id.tomato_view);
        myDataText = (TextView) findViewById(R.id.my_data_text);
        settingText = (TextView) findViewById(R.id.setting_text);
        musicText = (TextView) findViewById(R.id.music_text);
        totalHoursText = (TextView) findViewById(R.id.my_total_hours);
        totalMinutesText = (TextView) findViewById(R.id.my_total_minutes);
        helpText = (TextView) findViewById(R.id.help_text);
        startText = (TextView) mTomatoView.findViewById(R.id.btn_start_count_down);
        timeText = (TextView) mTomatoView.findViewById(R.id.text_time);
        myDataText.setOnClickListener(this);
        settingText.setOnClickListener(this);
        musicText.setOnClickListener(this);
        totalHoursText.setOnClickListener(this);
        totalMinutesText.setOnClickListener(this);
        helpText.setOnClickListener(this);
        startText.setOnClickListener(this);
        mTomatoView.setTomatoStatusListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_data_text:

                break;
            case R.id.music_text:

                break;
            case R.id.setting_text:

                break;
            case R.id.btn_start_count_down:
                if (!mTomatoView.isCountDowning()) {
                    mPresenter.createNewTomato();
                } else {
                    mPresenter.cancelTomato();
                }
                break;
            case R.id.my_total_minutes:

                break;
            case R.id.my_total_hours:

                break;
            case R.id.help_text:

                break;
        }
    }

    @Override
    public void showCountDownTime() {

    }

    @Override
    public void cancelCountDownTime() {
        mTomatoView.cancelTomato();
    }

    @Override
    public void startCountDownTime(Tomato tomato) {
        mTomatoView.setTomato(tomato);
        mTomatoView.startTomato();
    }

    @Override
    public void interrupt() {

    }

    @Override
    public void overTomato() {

        mTomatoView.overTomato();
    }

    @Override
    public void finishTomato() {

        mPresenter.overTomato();
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
