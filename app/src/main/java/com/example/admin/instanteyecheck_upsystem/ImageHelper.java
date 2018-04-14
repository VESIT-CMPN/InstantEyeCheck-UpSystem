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

public class ImageHelper extends SQLiteOpenHelper {
    public static final String TAG=ImageHelper.class.getSimpleName();
    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "EYE_APP.db";
    private static final String TABLE_NAME = "RESULT";
    private static String rid,uid,dname,did,probability,dimage;
    SQLiteDatabase db;

    private static String Create_table =" CREATE TABLE RESULT(RID PRIMARY KEY INTEGER NOT NULL,UID INTEGER ,FOREIGN KEY(UID)REFERENCES CONTACT(ID),DNAME TEXT NOT NULL,DID INTEGER NOT NULL,PROBABILITY REAL NOT NULL,DIMAGE BLOB";

    public ImageHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, DATABSE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="Drop table if exists "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void INSERTRESULT(RESIMAGE RI)
    {
        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();


        String query ="Select * from "+TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);
        int count = cursor.getCount();

        String q1="select id from contact where ";
        Cursor c=db.rawQuery(q1,null);
        int id=cursor.getPosition();

        values.put(rid,count);
        values.put(uid,id);
        values.put(dname,RI.getDname());
        values.put(did,RI.getDid());
        values.put(probability,RI.getProb());
        values.put(dimage, String.valueOf(RI.getImage()));

        long id1= db.insert(TABLE_NAME,null,values);
        db.close();

        Log.d(TAG,"image added"+id1);

    }
}
