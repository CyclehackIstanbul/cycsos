package com.hipo.cycle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by baris on 21/06/15.
 */
public class Location {

    @SerializedName("__type")
    private String type;
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = "GeoPoint";
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", type='" + type + '\'' +
                ", longitude=" + longitude +
                '}';
    }
}
