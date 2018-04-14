package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class question4b extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4b);
        final RadioButton buttonOne = (RadioButton)findViewById(R.id.yes4b);
        final RadioButton buttonTwo = (RadioButton)findViewById(R.id.no4b);

        buttonOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    //Go to the activity for button 1 here
                    question4b.this.startActivity(new Intent(question4b.this, question7b.class));
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
                    question4b.this.startActivity(new Intent(question4b.this, question7a.class));
                    buttonOne.setChecked(false);
                }
            }
        });

    }
}

