package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class blepharitisresult extends AppCompatActivity {
    HistoryHelper helper = new HistoryHelper(this);
    name name=new name();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blepharitisresult);
        Log.d("hi","xentered");
        TextView probability = (TextView) findViewById(R.id.probabilityvalue);
        Intent mIntent = getIntent();
        double intValue = mIntent.getDoubleExtra("probability", 0.0);
        String prob = Double.toString(intValue);
        probability.setText(prob);
        String data = name.Username;
        Log.d("name anisha", "name hi " + data);

        Historytable ht = new Historytable();
        ht.setHuname(data);
        ht.setDname("Blepharitis");
        ht.setHpercent(intValue);
        helper.insertHistory(ht);
    }
}
