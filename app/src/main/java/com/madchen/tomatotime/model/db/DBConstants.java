package com.madchen.tomatotime.model.db;

/**
 * Created by chenwei on 17/03/2017.
 */

public interface DBConstants {

    String DB_NAME = "db_tomato";
    String TABLE_NAME = "table_tomato";
    int DB_VERSION = 1;

    String CREATE_TOMATO_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + TomatoTableField._id + " INTEGER AUTO_INCREMENT, " +
            TomatoTableField.minutes + " LONG NOT NULL, " + TomatoTableField.startTimeL + " LONG NOT NULL, " +
            " LONG NOT NULL, " + TomatoTableField.interruptCount + " INT NOT NULL"
            + "PRIMARY KEY (" + TomatoTableField._id + "));";

    interface TomatoTableField {

        String _id = "_id";
        String minutes = "minutes";
        String interruptCount = "interruptCount";
        String startTimeL = "startTime";
    }
}
