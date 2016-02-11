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
import android.os.Bundle;
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
        editButton.setTag(position);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cur_pos = (Integer)v.getTag();
                FragmentManager fm = ((Activity) context).getFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("name", values[cur_pos].getName());
                bundle.putString("teacher", values[cur_pos].getTeacher());
                bundle.putInt("id", values[cur_pos].getId());
                bundle.putInt("number", values[cur_pos].getNumber());
                EditClassFragment dialog = new EditClassFragment();
                dialog.setArguments(bundle);
                dialog.show(fm, "mydialog");
            }
        });

        numberView.setText(Integer.toString(values[position].getNumber()));
        if(values[position].getName() != null && !values[position].getName().isEmpty())
            nameView.setText(values[position].getName());
        else
            nameView.setText("None");
        teacherView.setText(values[position].getTeacher());

        return classItemView;
    }


}
