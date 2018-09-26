package com.example.bauwensn.myapplication.Models;

import java.util.Date;

public class SensorData {

    private String deviceId;
    private Date date;
    private String adresse;
    private String proximity;


    public String getId() {
        return deviceId;
    }

    public void setId(String id) {
        this.deviceId = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProximity() {
        return proximity;
    }

    public void setProximity(String proximity) {
        this.proximity = proximity;
    }

    public SensorData(String id, String adresse, String proximity) {
        this.deviceId = id;
        this.adresse = adresse;
        this.proximity = proximity;
    }
}
