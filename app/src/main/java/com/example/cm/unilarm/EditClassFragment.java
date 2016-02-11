package com.example.cm.unilarm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by cm on 10.02.2016.
 */
public class EditClassFragment extends DialogFragment {
    String name;
    String teacher;
    int id;
    int number;

    EditText nameEdit;
    EditText teacherEdit;
    Button btnAccept;

    public EditClassFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        teacher = getArguments().getString("teacher");
        id = getArguments().getInt("id");
        number = getArguments().getInt("number");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_class_fragment, null);

        nameEdit = (EditText)v.findViewById(R.id.editName);
        teacherEdit = (EditText)v.findViewById(R.id.editTeacher);
        btnAccept = (Button)v.findViewById(R.id.btnAccept);

        if (name != null && !name.isEmpty())
        {
            nameEdit.setText(name);
        }

        if (teacher != null && !teacher.isEmpty())
        {
            teacherEdit.setText(teacher);
        }

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( nameEdit.getText().toString().trim().equals("")){
                    nameEdit.setError("Class name is required!");
                    return;
                }

                SQLiteOpenHelper unilarmDbHelper = new UnilarmDatabaseHelper(v.getContext());
                SQLiteDatabase db = unilarmDbHelper.getWritableDatabase();

                ContentValues content = new ContentValues();
                content.put("NAME", nameEdit.getText().toString());
                content.put("TEACHER", teacherEdit.getText().toString());
                content.put("_id", id);
                content.put("NUMBER", number);

                try
                {

                    db.insertWithOnConflict("CLASSES", null, content, SQLiteDatabase.CONFLICT_REPLACE);
                }
                catch (Exception e)
                {
                    int ss = 1;
                }

                dismiss();
            }
        });

        return v;
    }


}
