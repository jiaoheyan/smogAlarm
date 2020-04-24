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
        db.execSQL("insert into smogData values(?,?,?)",
                new Object[] { sb.getTime(), sb.getTemp(), sb.getHum() });
    }
    // 删除数据
    public void delete(String name) {
        db.execSQL("delete from smogData where name=?", new String[] { name });
    }

    // 查询所有的联系人信息
    public List<SmogBean> queryMany() {
        ArrayList<SmogBean> sbs = new ArrayList<SmogBean>();
        Cursor c = db.rawQuery("select * from smogData", null);
        while (c.moveToNext()) {
            SmogBean sb = new SmogBean();
            sb.setTime(c.getString(0));
            sb.setTemp(c.getString(1));
            sb.setHum(c.getString(2));
            sbs.add(sb);
        }
        c.close();
        return sbs;
    }

}
