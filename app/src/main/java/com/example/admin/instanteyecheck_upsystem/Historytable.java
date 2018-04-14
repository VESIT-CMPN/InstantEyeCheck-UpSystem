package com.example.admin.instanteyecheck_upsystem;


public class Historytable {
    String huname,hdname;
    double hpercent;

    public void setHuname(String huname)
    {
        this.huname= huname;
    }

    public String getHuname()
    {
        return this.huname;
    }

    public void setDname(String hdname)
    {
        this.hdname= hdname;
    }

    public String getHdname() {return this.hdname;}

    public void setHpercent(double hpercent) {this.hpercent = hpercent;}

    public double getHpercent() {return this.hpercent;}
}