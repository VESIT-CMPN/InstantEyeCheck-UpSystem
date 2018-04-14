package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question9d extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9d);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes9d);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no9d);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question9d.this.startActivity(new Intent(question9d.this, allergyanaphylaxis.class));
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
                    question9d.this.startActivity(new Intent(question9d.this, question2.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}
