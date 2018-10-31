package com.example.user.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        final SessionManagement sessionManagement = new SessionManagement(this);
        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if (email.matches("") || email.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Email dan Password Tidak Boleh Kosong / Space!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    sessionManagement.createLoginSession(edtEmail.getText().toString(), edtPassword.getText().toString());
                    goToActivity();
                }
            }
        });
    }

    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(mIntent);
    }
}
