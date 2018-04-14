package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question3a extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3a);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes3a);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no3a);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question3a.this.startActivity(new Intent(question3a.this, question4a.class));
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
                    question3a.this.startActivity(new Intent(question3a.this, question3b.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}

