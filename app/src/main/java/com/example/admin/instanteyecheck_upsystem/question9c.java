package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question9c extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9c);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes9c);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no9c);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question9c.this.startActivity(new Intent(question9c.this, viralconjunctivitis.class));
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
                    question9c.this.startActivity(new Intent(question9c.this, question10.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}
