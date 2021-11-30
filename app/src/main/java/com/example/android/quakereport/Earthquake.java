package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude;
    private String mlocation;
    private String mdate;

    public Earthquake(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mlocation = location;
        mdate = date;
    }

    public String getMagintude(){ return mMagnitude; }
    public String getlocation(){ return mlocation; }
    public String getdate(){ return mdate; }
}
