package com.hipo.cycle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by baris on 21/06/15.
 */
//"owner":{
//        "__op":"AddRelation",
//        "objects":[]
//        },
//        "location":{}
public class Owner {
    private ArrayList<ObjectP> objects;
    @SerializedName("__op")
    private String op;

    public Owner(ArrayList<ObjectP> objects) {
        this.objects = objects;
        this.op = "AddRelation";
    }


    public ArrayList<ObjectP> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<ObjectP> objects) {
        this.objects = objects;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "Owner{" +
                ", objects=" + objects +
                ", op='" + op + '\'' +
                '}';
    }
}
