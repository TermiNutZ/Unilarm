package com.example.cm.unilarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cm on 08.02.2016.
 */
public class ClassListAdapter extends ArrayAdapter<ClassModel> {
    private final Context context;
    private final ClassModel[] values;

    public ClassListAdapter(Context context, ClassModel[] values) {
        super(context, R.layout.class_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View classItemView = inflater.inflate(R.layout.class_item, parent, false);

        TextView numberView = (TextView) classItemView.findViewById(R.id.number);
        TextView nameView = (TextView) classItemView.findViewById(R.id.name);
        TextView teacherView = (TextView) classItemView.findViewById(R.id.teacher);
        Button editButton = (Button) classItemView.findViewById(R.id.buttonEdit);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = ((Activity)context).getFragmentManager();
                EditClassFragment dialog = new EditClassFragment();
                dialog.show(fm, "mydialog");

/*                SQLiteOpenHelper unilarmDbHelper = new UnilarmDatabaseHelper(context);
                SQLiteDatabase db = unilarmDbHelper.getWritableDatabase();

                ContentValues content =
                db.*/
            }
        });

        numberView.setText(Integer.toString(values[position].getNumber()));
        nameView.setText(values[position].getName());
        teacherView.setText(values[position].getTeacher());

        return classItemView;
    }


}
