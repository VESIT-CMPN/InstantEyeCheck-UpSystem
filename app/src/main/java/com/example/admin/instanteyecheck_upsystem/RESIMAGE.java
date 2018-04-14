package com.example.admin.instanteyecheck_upsystem;

import java.sql.Blob;

/**
 * Created by DHiraJ on 10-Feb-18.
 */

public class RESIMAGE {
    Blob img;
    public void setImage(Blob img){img=this.img;}
    public Blob getImage(){return this.img;}
    float p;
    public void setProb(float p){p=this.p;}
    public float getProb(){return this.p;}
    int did;
    public void setDid(int did){did = this.did;}
    public int getDid(){return this.did;}

    String dname;
    public void setDname(String dname){dname=this.dname;}
    public String getDname(){ return this.dname;}

}
