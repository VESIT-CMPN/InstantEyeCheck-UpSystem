package com.example.admin.instanteyecheck_upsystem;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor edi;
    Context cxt;
    public Session(Context cxt)
    {
        this.cxt=cxt;
        prefs=cxt.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        edi=prefs.edit();
    }
    public void setLoggedIn(boolean loggedin)
    {
        edi.putBoolean("LoggedInMode",loggedin);
        edi.commit();
    }
    public boolean loggedin()
    {
        return prefs.getBoolean("LoggedInMode", false );
    }

} 