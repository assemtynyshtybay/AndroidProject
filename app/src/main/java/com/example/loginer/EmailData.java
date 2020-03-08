package com.example.loginer;

public class EmailData {
    private String mSender;
    private String mTitle;
    private String mDetails;
    private String mTime;

    public EmailData(String mSender, String mTitle, String mDetails, String mTime) {
        this.mSender = mSender;
        this.mTitle = mTitle;
        this.mDetails = mDetails;
        this.mTime = mTime;
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDetails() {
        return mDetails;
    }

    public void setmDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
