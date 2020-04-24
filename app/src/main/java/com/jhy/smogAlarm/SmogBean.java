package com.jhy.smogAlarm;

public class SmogBean {
    private String temp;
    private String hum;
    private String time;

    public SmogBean() {
        super();
    }

    public SmogBean(String temp, String hum, String time) {
        super();
        this.temp = temp;
        this.hum = hum;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
