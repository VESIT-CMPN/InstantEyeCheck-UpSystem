package com.example.admin.instanteyecheck_upsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG=DatabaseHelper.class.getSimpleName();
    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "EYE_APP.db";
    private static final String TABLE_NAME = "Contact";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";



    SQLiteDatabase db;

    private static final String TABLE_CREATE=
            "create table contact(id integer primary key not null , name text not null , email text not null , username text not null , password text not null)";
    private static final String TABLE_HIS=
            "create table history ( hid integer primary key not null , huname text not null , dname text not null , hpercent real ) " ;

    public DatabaseHelper(Context context) {
        //super(context, name, factory, version);
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
            db.execSQL(TABLE_HIS);
            this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            String query ="Drop table if exists "+TABLE_NAME;
            db.execSQL(query);
            this.onCreate(db);
    }


    public void insertContact(Contact c)
    {
        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query ="Select * from "+TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);
            int count = cursor.getCount();

        values.put(COL_ID,count);
        values.put(COL_NAME,c.getName());
        values.put(COL_EMAIL,c.getEmail());
        values.put(COL_USERNAME,c.getUsername());
        values.put(COL_PASSWORD,c.getPassword());

        long id= db.insert(TABLE_NAME,null,values);
        db.close();

        Log.d(TAG,"UserAdded"+id);

    }

    public String searchPass(String username)
    {
      db = this.getReadableDatabase();
      String searchQuery ="Select username,password from contact";
        Cursor cursor = db.rawQuery(searchQuery,null);
            String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);
                if(a.equalsIgnoreCase(username))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());

        }
        return b;



    }
    public List<Historytable> getdata(){

        List<Historytable> data=new ArrayList<>();
        db = this.getWritableDatabase();
        String s= "select * from history";
        Cursor cursor = db.rawQuery(s,null);
        StringBuffer stringBuffer = new StringBuffer();
         Historytable h = null;
        while (cursor.moveToNext())
        {
            h = new Historytable();
            String dname = cursor.getString(cursor.getColumnIndexOrThrow("dname"));
            Float v  = cursor.getFloat(cursor.getColumnIndexOrThrow("hpercent"));
            String name1 =cursor.getString(cursor.getColumnIndexOrThrow("huname"));
            if(name1.equalsIgnoreCase(name.Username))
            {
            h.setDname(dname);
            h.setHpercent(v);
            stringBuffer.append(h);
            data.add(h);
            }
        }



        //

        return data;
    }


    /*public boolean getUser(String usename,String pass)
    {
        db= this.getReadableDatabase();
        String Equery = "Select username,password from Contact";
        Cursor c = db.rawQuery(Equery,null);
        c.moveToFirst();
        if(c.getCount()>0)
        {
            return true;
        }
        c.close();
        db.close();


        return false;


    }*/
    public boolean SearchUname(String Uname)
    {
        db= this.getReadableDatabase();
        String Equery = "Select username from Contact";
        Cursor c = db.rawQuery(Equery,null);
        boolean valid =true;
        String a;
        if(c.moveToFirst())
        {
            do
                {
                a=c.getString(0);
                if((a.trim()).equalsIgnoreCase(Uname.trim()))
                {
                    valid= false;
                    break;
                }
            }
            while(c.moveToNext());
        }
            return valid;
    }
}