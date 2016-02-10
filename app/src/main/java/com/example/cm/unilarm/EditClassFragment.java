package com.example.cm.unilarm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by cm on 10.02.2016.
 */
public class EditClassFragment extends DialogFragment {
    public EditClassFragment()
    {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText titleBox = new EditText(getActivity());
        titleBox.setHint("Title");
        layout.addView(titleBox);

        final EditText descriptionBox = new EditText(getActivity());
        descriptionBox.setHint("Description");
        layout.addView(descriptionBox);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setView(layout);

        return dialog.create();
    }
}
