package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class docpat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docpat);
        Button button = (Button) findViewById(R.id.option1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(docpat.this, signlogindoc.class);
                startActivity(intent);

            }
        });
        Button button1 = (Button) findViewById(R.id.option2);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(docpat.this, signlogin.class);
                startActivity(intent);

            }
        });

    }
}
