package com.mukundmurarka.medicinereminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Medicine extends SQLiteOpenHelper {

    Medicine(Context context) {
        super(context, "USERDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(" +
                "Name text," +
                "Date text," +
                "Time text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);

    }

    public void addData(String name_r, String date_r, String time_r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name_r);
        contentValues.put("Date", date_r);
        contentValues.put("Time", time_r);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("USER", null, contentValues);
    }

    public Cursor getData() {
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.query("USER",null,null,null,null,null,null);
        return cursor;
    }

    public void onDelete(String name) {
        SQLiteDatabase db =  getWritableDatabase();
        String[] whreArg = {name};
        db.delete("USER","Name = ?", whreArg);

    }
}
