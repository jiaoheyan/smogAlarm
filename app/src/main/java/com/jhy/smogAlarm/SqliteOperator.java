package com.jhy.smogAlarm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SqliteOperator {
    private DataSQlite dataSQlite;
    private SQLiteDatabase db;

    public SqliteOperator(Context context) {
        dataSQlite = new DataSQlite(context, "smogData", null, 1);
        db = dataSQlite.getWritableDatabase();
        db.close();
    }
    // 添加数据
    public void add(SmogBean sb){
        db = dataSQlite.getWritableDatabase();
        db.execSQL("insert into smogData(time,temps,hum) values('"+sb.getTime()+"','"+sb.getTemp()+"','"+sb.getHum()+"')");
        db.close();
    }
    // 删除数据
    public void delete(String name) {
        db = dataSQlite.getWritableDatabase();
        db.execSQL("delete from smogData where name=?", new String[] { name });
        db.close();
    }

    // 查询所有的联系人信息
    public List<SmogBean> queryMany() {
        db = dataSQlite.getWritableDatabase();
        ArrayList<SmogBean> sbs = new ArrayList<SmogBean>();
        Cursor c = db.rawQuery("select * from smogData", null);
        while (c.moveToNext()) {
            SmogBean sb = new SmogBean();
            sb.setTime(c.getString(1));
            sb.setTemp(c.getString(2));
            sb.setHum(c.getString(3));
            sbs.add(sb);
        }
        c.close();
        db.close();
        return sbs;
    }

}
