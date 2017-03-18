package com.madchen.tomatotime.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.madchen.tomatotime.model.Tomato;

/**
 * Created by chenwei on 17/03/2017.
 */

public class DBManager implements DBConstants {

    private Context mContext;
    private TomatoDBHelper mTomatoDBHelper;
    private SQLiteDatabase mSQLiteDatabase;

    public DBManager(Context context) {
        mContext = context;
        mTomatoDBHelper = new TomatoDBHelper(mContext, DBConstants.DB_NAME, null, DBConstants.DB_VERSION);
        mSQLiteDatabase = mTomatoDBHelper.getWritableDatabase();
    }

    public long saveTomato(Tomato tomato) {
        long result = -1;
        ContentValues cv = new ContentValues();
        cv.put(TomatoTableField.minutes, tomato.getMinutes());
        cv.put(TomatoTableField.interruptCount, tomato.getInterrupt());
        cv.put(TomatoTableField.startTimeL, tomato.getStartTimeL());
        result = mSQLiteDatabase.insert(DB_NAME, null, cv);
        return result;
    }

    public Tomato getTomato() {
        Tomato tomato = new Tomato(0, 0);

        return tomato;
    }
}
