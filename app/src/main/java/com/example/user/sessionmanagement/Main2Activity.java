package com.example.user.sessionmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    SessionManagement sessionManagement;
    TextView tvEmail;
    Button buttonLogout;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();

        Toast.makeText(this, sessionManagement.isLoggedIn()+"", Toast.LENGTH_LONG).show();

        tvEmail.setText(loginUser.get(sessionManagement.KEY_EMAIL));

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });
    }
}
