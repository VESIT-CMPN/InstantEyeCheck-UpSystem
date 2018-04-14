package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question8c extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8c);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes8c);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no8c);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question8c.this.startActivity(new Intent(question8c.this,  question9d.class));
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
                    question8c.this.startActivity(new Intent(question8c.this, question9e.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}
