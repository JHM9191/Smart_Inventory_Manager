package com.example.topmenuexample.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.topmenuexample.MainActivity;
import com.example.topmenuexample.R;

public class CalculateDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_Calculate_Dialog = "caclulate dialog";
    Button cdConfirm,cdCancel;
    TextView dialog_totalcost,dialog_admin,dialog_enddate;

    public CalculateDialogFragment(){}

    public static CalculateDialogFragment getInstance(){
        CalculateDialogFragment ccdf = new CalculateDialogFragment();
        return ccdf;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.daycalculate_dialog,container);
        cdConfirm = v.findViewById(R.id.button_cdialogconfirm);
        cdCancel = v.findViewById(R.id.button_dismissdialog);
        dialog_enddate = v.findViewById(R.id.dialog_enddate);
        dialog_admin = v.findViewById(R.id.dialog_admin);
        dialog_totalcost = v.findViewById(R.id.dialog_totalcost);

        final String endTime = ((MainActivity)getActivity()).getCurrentTime();
        dialog_enddate.setText(endTime);
        dialog_admin.setText(((MainActivity)getActivity()).tempClerk);
        dialog_totalcost.setText(((MainActivity)getActivity()).tempTotalCost+"");

        cdConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // 영업마감시간 갱신 , 주문 상세 내역 초기화 //
                dismiss();

            }
        });
        cdCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return v;

    }

    @Override
    public void onClick(View v) {


        dismiss();

    }
}
