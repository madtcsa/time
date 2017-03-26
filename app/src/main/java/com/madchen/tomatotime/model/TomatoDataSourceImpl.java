package com.madchen.tomatotime.model;

import android.content.Context;

import com.madchen.tomatotime.model.db.DBManager;

/**
 * Created by chenwei on 18/03/2017.
 */

public class TomatoDataSourceImpl implements TomatoDataSource {

    private DBManager mDBManager;

    public TomatoDataSourceImpl(Context context) {

        mDBManager = new DBManager(context);
    }

    @Override
    public void saveTomato(Tomato tomato) {

    }

    @Override
    public void loadAllTomato(LoadAllTomatoCallBack loadAllTomatoCallBack) {

    }

    @Override
    public void loadMonthTomatoes(long monthTimeL, LoadMonthTomatoesCallBack loadMonthTomatoesCallBack) {

    }

    @Override
    public void loadDayTomatoes(long dayTimeL, LoadDayTomatoesCallBack loadDayTomatoesCallBack) {

    }


}
