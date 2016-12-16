package com.runexa.hci_uas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //TODO : Mock Data Set
    userDataSet[] arrUser = {
            new userDataSet(0,"richie@mail.com","bukan1234",new cvDataset("Richie",0,"7-10-96","Tigaraksa","6285284558248","richie@mail.com","","","","")),
            new userDataSet(1,"jogun@mail.com","1234",new cvDataset("Jonathan",0,"1-12-96","Disana","6201010101","jogun@mail.com","","","","")),
            new userDataSet(2,"johan@mail.com","abcd",new cvDataset("Johan",0,"10-10-96","Disini","6262626262","johan@mail.com","","","",""))
    };

    EditText idemail;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idemail = (EditText) findViewById(R.id.login_email);
        pass = (EditText) findViewById(R.id.login_password);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean found = false;
                for (userDataSet u: arrUser) {
                    if(u.email.equals(idemail.getText().toString()) && u.password.equals(pass.getText().toString())){
                        found = true;
                        currentUser.setCurrentUser(u);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }
                if((!found)){
                    Toast.makeText(getBaseContext(),"Email atau Password Salah",Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView registerButton = (TextView) findViewById(R.id.login_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
