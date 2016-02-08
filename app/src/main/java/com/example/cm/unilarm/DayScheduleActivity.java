package com.example.cm.unilarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DayScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        ListView listView = (ListView)findViewById(R.id.classList);

        ClassModel[] values = new ClassModel[2];
        values[0] = new ClassModel();
        values[0].setName("Neural Network");
        values[0].setTeacher("Madonov AN");
        values[0].setNumber(1);
        values[1] = new ClassModel();
        values[1].setName("Neural Network");
        values[1].setTeacher("Madonov AN");
        values[1].setNumber(2);
        ClassListAdapter adapter = new ClassListAdapter(this, values);
        listView.setAdapter(adapter);
    }
}
