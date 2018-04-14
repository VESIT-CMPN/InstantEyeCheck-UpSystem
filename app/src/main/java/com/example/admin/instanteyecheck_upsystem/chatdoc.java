package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chatdoc extends AppCompatActivity {
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatdoc);
        Button logout= (Button)findViewById(R.id.button2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session=new Session(chatdoc.this);
                session.setLoggedIn(false);
                finish();
                startActivity(new Intent(chatdoc.this, login.class));
            }
        });
    }
}
