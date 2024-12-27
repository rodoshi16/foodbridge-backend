package com.rodoshi.googlemapsAPI.Model;

public class FoodBankData {
    Double latitude;
    Double longitude;
    String name;
    String address;
    String open;
    String hours;


    public FoodBankData(double latitude, double longitude, String name, String address, String open, String hours){
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.open = open;
        this.hours = hours;
    }


    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getOpen(){
        return this.open;
    }

    public String getHours(){
        return this.hours;
    }

    public Double getLatitude(){
        return this.latitude;
    }

    public Double getLongitude(){
        return this.longitude;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setOpen(String open){
        this.open = open;
    }

    public void setHours(String hours){
        this.hours = hours;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }












}
