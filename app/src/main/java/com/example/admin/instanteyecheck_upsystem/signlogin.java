package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class signlogin extends AppCompatActivity {
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signlogin);
        session = new Session(this);
        if(session.loggedin())
        {
            startActivity(new Intent(signlogin.this,navigation.class));
            finish();
        }
        Button button = (Button) findViewById(R.id.option1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(signlogin.this, signup.class);
                startActivity(intent);

            }
        });
        Button button1 = (Button) findViewById(R.id.option2);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(signlogin.this, login.class);
                startActivity(intent);

            }
        });
    }
}
