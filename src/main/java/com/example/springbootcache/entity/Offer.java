package com.example.springbootcache.entity;

public class Offer  {
    private String voice ;
    private String data ;
    private String sms ;

    public Offer(String voice, String data, String sms) {
        this.voice = voice;
        this.data = data;
        this.sms = sms;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}
