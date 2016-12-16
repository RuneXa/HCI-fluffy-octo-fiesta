package com.runexa.hci_uas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText nama;
    EditText email;
    EditText pass;
    EditText passc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = (EditText) findViewById(R.id.register_nama);
        email = (EditText) findViewById(R.id.register_email);
        pass = (EditText) findViewById(R.id.register_password);
        passc = (EditText) findViewById(R.id.register_confirmation);


        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().equals(passc.getText().toString())){
                    currentUser.setCurrentUser(
                            new userDataSet(10,email.getText().toString(),pass.getText().toString()
                                    ,new cvDataset(nama.getText().toString(),
                                    0,
                                    "",
                                    "",
                                    "62",
                                    email.getText().toString(),
                                    "",
                                    "",
                                    "",
                                    "")));

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(),"Password Tidak Sama", Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView loginButton = (TextView) findViewById(R.id.register_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
