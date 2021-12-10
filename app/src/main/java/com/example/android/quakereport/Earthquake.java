package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude;
    private String mlocation;
    private String mdate;
    private String murl;

    public Earthquake(String magnitude, String location, String date, String url){
        mMagnitude = magnitude;
        mlocation = location;
        mdate = date;
        murl = url;
    }

    public String getMagintude(){ return mMagnitude; }
    public String getlocation(){ return mlocation; }
    public String getdate(){ return mdate; }
    public String geturl(){ return murl; }
}
