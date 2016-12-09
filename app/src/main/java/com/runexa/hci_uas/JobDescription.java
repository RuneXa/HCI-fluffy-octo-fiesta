package com.runexa.hci_uas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JobDescription extends AppCompatActivity {

    protected TextView Title;
    protected TextView Pos;
    protected TextView Address;
    protected TextView Email;
    protected TextView Desc;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_description);

        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Title = (TextView) findViewById(R.id.desc_title_PH);
        Pos = (TextView) findViewById(R.id.desc_jobPos_PH);
        Address = (TextView) findViewById(R.id.desc_address_PH);
        Email = (TextView) findViewById(R.id.desc_email_PH);
        Desc = (TextView) findViewById(R.id.desc_desc_PH);
        submit = (Button) findViewById(R.id.desc_submit);

        mDataset data = (mDataset) getIntent().getSerializableExtra("data");
        Title.setText(data.title);
        Pos.setText(data.position);
        Address.setText(data.address);
        Email.setText(data.email);
        Desc.setText(data.description);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(submit.getRootView(),"CV Terkirim",Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

}
