package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {

    private Session session;
   DatabaseHelper helper=new DatabaseHelper(this);
   String Susername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(this);
        if(session.loggedin())
        {
       startActivity(new Intent(login.this,navigation.class));
            finish();
        }
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText username = (EditText) findViewById(R.id.Tusername);
            Susername = username.getText().toString();
            name.Username=Susername;
            Log.d("hiiii","hiiiiiii "+name.Username);

            EditText p = (EditText) findViewById(R.id.Tpassword);
            String ps = p.getText().toString();

            String password = helper.searchPass(Susername);
            //String username=helper.
            if (helper.SearchUname(Susername) == false) {


                if (ps.equals(password)) {
                    session.setLoggedIn(true);
                    Intent i = new Intent(login.this, navigation.class);
                    Intent intent = new Intent(login.this,acuteglaucomaresult.class);
                    intent.putExtra("username",Susername);
                    startActivity(i);
                    finish();
                } else {
                    Toast temp = Toast.makeText(login.this, "Username and Password Don't match!", Toast.LENGTH_LONG);
                    temp.show();
                }
            } else {
                Toast.makeText(this, "Account doesn't exist", Toast.LENGTH_LONG).show();
            }
        }
    }}