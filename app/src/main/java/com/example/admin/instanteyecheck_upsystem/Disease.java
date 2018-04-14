package com.example.admin.instanteyecheck_upsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DHiraJ on 10-Feb-18.
 */

public class Disease {
    int  did;
    String dname,treatment;

    public Disease(String dname, String treatment){
        this.dname=dname;
        this.treatment=treatment;
    }
    public Disease(int did, String dname, String treatment){
        this.did=did;
        this.dname=dname;
        this.treatment=treatment;
    }

    public void setDid(int did){
        this.did=did;
    }
    public void setDiseaase(String dname){
        this.dname=dname;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public int getDid(){return this.did;}
    public String getDname(){return this.dname;}
    public String getTreatment(){return this.treatment;}
    }

