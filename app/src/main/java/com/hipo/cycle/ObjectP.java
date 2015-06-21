package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */

//

import com.google.gson.annotations.SerializedName;
//
//"__type":"Pointer",
//        "className":"Profile",
//        "objectId":"***"
public class ObjectP {
    @SerializedName("__type")
    private String type;
    private String className;
    private String objectId;

    public ObjectP(String objectId) {
        this.objectId = objectId;
        this.type = "Pointer";
        this.className = "Profile";
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ObjectP{" +
                "className='" + className + '\'' +
                ", type='" + type + '\'' +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
