package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question3c extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3c);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes3c);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no3c);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question3c.this.startActivity(new Intent(question3c.this, question4b.class));
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
                    question3c.this.startActivity(new Intent(question3c.this, question3b.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}

