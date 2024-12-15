package com.rodoshi.googlemapsAPI.Model;
public class MapData {
    double latitude;
    double longitude;
    int zoom;
    String location;


    public MapData(double latitude, double longitude, int zoom, String location){
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoom = zoom;
        this.location = location;

    }

    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
    public double getZoom(){
        return this.zoom;
    }

    public String getLocation(){
        return this.location;
    }

    public double setLatitude(double latitude){
        return this.latitude = latitude;
    }

    public double setLongitude(double longitude){
        return this.longitude = longitude;
    }

    public double setZoom(int zoom){
        return this.zoom = zoom;
    }

    public String setLocation(String location){
        return this.location = location;
    }










}
