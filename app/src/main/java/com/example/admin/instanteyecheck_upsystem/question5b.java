package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question5b extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5b);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes5b);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no5b);
        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question5b.this.startActivity(new Intent(question5b.this, question6a.class));
                    buttonTwo.setChecked(false);
                }
            }
        });
        buttonTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 2 here
                    question5b.this.startActivity(new Intent(question5b.this, question3b.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}

