package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question10 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes10);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no10);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question10.this.startActivity(new Intent(question10.this, measles.class));
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
                    question10.this.startActivity(new Intent(question10.this, question2.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}