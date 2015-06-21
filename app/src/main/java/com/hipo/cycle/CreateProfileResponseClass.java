package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */
public class CreateProfileResponseClass {
    private String objectId;

    public CreateProfileResponseClass() {
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "CreateProfileResponseClass{" +
                "objectId='" + objectId + '\'' +
                '}';
    }
}
