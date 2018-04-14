package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class logindoc extends AppCompatActivity {

    private Session session;
    DatabaseHelper1 helper=new DatabaseHelper1(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindoc);
        session = new Session(this);
        if(session.loggedin())
        {
            startActivity(new Intent(logindoc.this,chatdoc.class));
            finish();
        }
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText username = (EditText) findViewById(R.id.Tusername);
            String Susername = username.getText().toString();


            EditText p = (EditText) findViewById(R.id.Tpassword);
            String ps = p.getText().toString();

            String password = helper.searchPass(Susername);
            //String username=helper.
            if (helper.SearchUname(Susername) == false) {


                if (ps.equals(password)) {
                    session.setLoggedIn(true);
                    Intent i = new Intent(logindoc.this, chatdoc.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast temp = Toast.makeText(logindoc.this, "Username and Password Don't match!", Toast.LENGTH_LONG);
                    temp.show();
                }
            } else {
                Toast.makeText(this, "Account doesn't exist", Toast.LENGTH_LONG).show();
            }
        }
    }}