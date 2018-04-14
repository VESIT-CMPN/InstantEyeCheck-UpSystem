package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question8a extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8a);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes8a);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no8a);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question8a.this.startActivity(new Intent(question8a.this, question9a .class));
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
                    question8a.this.startActivity(new Intent(question8a.this, question2 .class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}
