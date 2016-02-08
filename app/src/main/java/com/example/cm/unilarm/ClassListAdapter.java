package com.example.cm.unilarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        numberView.setText(Integer.toString(values[position].getNumber()));
        nameView.setText(values[position].getName());
        teacherView.setText(values[position].getTeacher());

        return classItemView;
    }
}
