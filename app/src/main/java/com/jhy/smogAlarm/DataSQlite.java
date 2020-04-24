package com.jhy.smogAlarm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataSQlite extends SQLiteOpenHelper {
    public static final String SMOG_DATA = "create table smogData(_id integer primary key, time varchar(20), temps varchar(20), hum varchar(20))";
    private Context mContext;

    public DataSQlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SMOG_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
