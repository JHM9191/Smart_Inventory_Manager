package com.example.topmenuexample.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.topmenuexample.R;

public class CustomDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_EVENT_DIALOG = "dialog_event";

    public CustomDialogFragment(){}

    public static CustomDialogFragment getInstance(){
        CustomDialogFragment cdf = new CustomDialogFragment();
        return cdf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.customdialog,container);
        Button confirm = (Button) v.findViewById(R.id.button_confirm);
        confirm.setOnClickListener(this);
        return  v;


    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
