package com.example.cm.unilarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cm on 08.02.2016.
 */
public class UnilarmDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "unilarm";
    private static final int DB_VERSION = 1;

    UnilarmDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CLASSES (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NUMBER INTEGER, " +
                "WEEKDAY INTEGER, " +
                "NAME TEXT, " +
                "TEACHER TEXT); ");

        insertClass(db, 1, 5, "Neural Network", "Madonnov AN");
        insertClass(db, 2, 5, "Neural Network", "Madonnov AN");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertClass(SQLiteDatabase db, int number,
                                    int weekday, String name, String teacher)
    {
        ContentValues classValues = new ContentValues();
        classValues.put("NUMBER", number);
        classValues.put("WEEKDAY", weekday);
        classValues.put("NAME", name);
        classValues.put("TEACHER", teacher);

        db.insert("CLASSES", null, classValues);
    }
}
