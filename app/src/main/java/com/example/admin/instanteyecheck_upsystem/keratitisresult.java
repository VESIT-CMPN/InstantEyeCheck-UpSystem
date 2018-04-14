package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class keratitisresult extends AppCompatActivity {
    HistoryHelper helper = new HistoryHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keratitisresult);
        TextView probability = (TextView) findViewById(R.id.probabilityvalue);
        Intent mIntent = getIntent();
        double intValue = mIntent.getDoubleExtra("probability",0.0);
        String prob=Double.toString(intValue);
        probability.setText(prob);
        String data =name.Username;
        Log.d("name anisha","name"+data);

        Historytable ht = new Historytable();
        ht.setHuname(data);
        ht.setDname("Keratisis");
        ht.setHpercent(intValue);
        helper.insertHistory(ht);

    }
}
