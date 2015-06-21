package com.hipo.cycle;

import java.util.ArrayList;

/**
 * Created by baris on 21/06/15.
 */
//"deviceType": "ios",
//        "deviceToken": "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
//        "channels": [
//        ""
//        ]
public class RegisterRequestClass {
    private String deviceType;
    private String deviceToken;
    private ArrayList<PushChannel> channels;
    private ObjectP profile;

    public RegisterRequestClass(String deviceToken,ObjectP profile) {
        this.deviceToken = deviceToken;
        this.channels = new ArrayList<>();
        this.deviceType = "android";
        this.profile = profile;
    }

    public ObjectP getProfile() {
        return profile;
    }

    public void setProfile(ObjectP profile) {
        this.profile = profile;
    }

    public ArrayList<PushChannel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<PushChannel> channels) {
        this.channels = channels;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "RegisterRequestClass{" +
                "channels=" + channels +
                ", deviceType='" + deviceType + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                '}';
    }
}
