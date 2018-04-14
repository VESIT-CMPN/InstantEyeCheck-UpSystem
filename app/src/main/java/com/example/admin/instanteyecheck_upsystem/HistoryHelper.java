package com.example.admin.instanteyecheck_upsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HistoryHelper extends SQLiteOpenHelper {

    public static final String TAG=DatabaseHelper.class.getSimpleName();
    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "EYE_APP.db";
    private static final String HISTORY_TABLE = "history";
    private static final String H_ID = "hid";
    private static final String H_UNAME = "huname";
    private static final String H_DNAME = "dname";
    private static final String H_PERCENT = "hpercent";
    SQLiteDatabase db;
    /*private static final String TABLE_HIS=
            "create table history ( hid integer primary key not null , huname text not null , dname text not null , hpercent real ) " ;*/
    public HistoryHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
               /* Log.d(TAG,"Inside Oncreate");
                db.execSQL(TABLE_HIS);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + HISTORY_TABLE;
        db.execSQL(query);

        onCreate(db);
    }
    public void insertHistory (Historytable h)
    {
        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query1 ="Select * from history ";
        Cursor cursor= db.rawQuery(query1,null);
        int count = cursor.getCount();

        values.put(H_ID,count);
        values.put(H_UNAME,h.getHuname());
        values.put(H_DNAME,h.getHdname());
        values.put(H_PERCENT,h.getHpercent());

        long id = db.insert(HISTORY_TABLE,null,values);
        db.close();
        Log.d(TAG,"history entered"+ id + "h_count  is "+count);

    }
    public double Prog(String dname)
    {
        db=this.getReadableDatabase();
        String huname=name.Username;
        String query= "Select * from history where huname=\""+huname+"\" AND dname=\""+dname+"\" ORDER BY hid DESC LIMIT 2";
        Log.d("lakhu",query);
        Cursor c= db.rawQuery(query,null);
        Log.d("lakhu", String.valueOf(c));
         double[] a= new double[2];
        int i=0;
        if(c.moveToFirst())
        {

            do{
                a[i]=c.getFloat(3);
                Log.d("lakhu",""+a[i]);
                i++;
            }
            while (c.moveToNext());

        }
        double res= a[1]-a[0];
        Log.d("lakhu",""+res);
        return res;




    }


}
