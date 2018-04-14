package com.example.admin.instanteyecheck_upsystem;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Math.abs;

public class progress extends AppCompatActivity {



    // define spinner
    HistoryHelper historyHelper= new HistoryHelper(this);
    Spinner sp ;



    //DEFINE TEXT VIEW

    TextView display_data ;

    //make string Arrary

    String names[] = {"Acute Glaucoma","Allergic Conjunctivitis","Allergy Anaphylaxis","Blepharitis","Stye","Keratisis"};

    //defins array adapter of string type

    ArrayAdapter<String> adapter;

    //define string variable for record

    String record= "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_progress);

        sp = (Spinner)findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        display_data = (TextView)findViewById(R.id.display_result);

        //set adapter to spinner

        sp.setAdapter(adapter);

        //set spinner method

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {

                    case 0:

                        record = "Acute Glucoma";

                        break;

                    case 1:

                        record = "Allergic Conjunctivitis";

                        break;

                    case 2:

                        record = "Allergy Anaphylaxis";

                        break;

                    case 3:

                        record = "Blepharitis";

                        break;

                    case 4:

                        record = "Stye";

                        break;

                    case 5:

                        record = "Keratisis";

                        break;




                }

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }


    //set display button click to show result

    public void diplsyResult(View view)

    {
            double res;
            res=historyHelper.Prog(record);
        display_data.setTextSize(20);
            if(res==0) {
                display_data.setText("You Have Not Progessed");
            }
            else if(res>0) {
                display_data.setText("You have Progessed by "+String.valueOf(res)+"%");
            }
            else {
                display_data.setText("Your disease has increased by "+String.valueOf(abs(res))+"%" );
            }
            }

    }

