package com.example.cm.unilarm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class DayScheduleActivity extends AppCompatActivity {

    private long weekday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        Intent intent = getIntent();
        weekday = intent.getLongExtra("Weekday", 1);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        SQLiteOpenHelper unilarmDbHelper = new UnilarmDatabaseHelper(this);
        SQLiteDatabase db = unilarmDbHelper.getReadableDatabase();

        Cursor cursor = db.query("CLASSES", new String[]{"NUMBER", "NAME", "TEACHER"}, "WEEKDAY = ?", new String[]{Long.toString(weekday)}, null, null, null);

        ClassModel[] values = new ClassModel[7];
        setDefault(values);
        try
        {
            if (cursor.moveToFirst()) {
                do {
                    int index = cursor.getInt(0) - 1;
                    values[index].setName(cursor.getString(1));
                    values[index].setTeacher(cursor.getString(2));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        catch (Exception e)
        {
            int p =5;
        }


        ListView listView = (ListView)findViewById(R.id.classList);


        ClassListAdapter adapter = new ClassListAdapter(this, values);
        listView.setAdapter(adapter);
    }

    private void setDefault(ClassModel[] values)
    {
        for (int i = 0; i < values.length; i++)
        {
            values[i] = new ClassModel();
            values[i].setNumber(i+1);
            values[i].setName("");
            values[i].setTeacher("");
        }
    }
}
