package com.example.topmenuexample.ui.main;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.topmenuexample.MainActivity;
import com.example.topmenuexample.R;
import com.example.topmenuexample.network.HttpHandler;

public class LoginDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_Login_Dialog = "Login Dialog";

    Button button_login, button_loginCancel;
    public EditText editText_ID, editText_PWD;

    public LoginDialogFragment() {
    }

    public static LoginDialogFragment getInstance() {
        LoginDialogFragment ldf = new LoginDialogFragment();
        return ldf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_dialog_layout, container);
        editText_ID = v.findViewById(R.id.editText_ID);
        editText_PWD = v.findViewById(R.id.editText_PWD);
        button_login = v.findViewById(R.id.button_login);
        button_loginCancel = v.findViewById(R.id.button_loginCancel);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText_ID.getText().toString();
                String pwd = editText_PWD.getText().toString();
                String startTime = ((MainActivity) getActivity()).getCurrentTime();
                ((MainActivity) getActivity()).tempStartTime = startTime;
                HttpTask task = new HttpTask(id, pwd);
                task.execute();
            }
        });
        button_loginCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {

        getDialog().setCancelable(false);
    }

    class HttpTask extends AsyncTask<Void, Void, String> {

        String url;

        public HttpTask(String id, String pwd) {
            url = "http://192.168.43.2:8080/top/loginChainTablet.top?";
            url += "id=" + id + "&pwd=" + pwd;

        }

        @Override
        protected String doInBackground(Void... voids) {
            Log.d("---", "Background Processing");
            return HttpHandler.getString(url);
        }


        @Override
        protected void onPostExecute(String s) {
            Log.d("---", "getFrom Server" + s.trim());

            if (s.trim().equals("1")) {
                getDialog().dismiss();
            } else {


            }

        }


    }

}

