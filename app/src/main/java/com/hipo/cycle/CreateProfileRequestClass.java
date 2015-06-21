package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */
public class CreateProfileRequestClass {
    private String name;
    private String phone;

    public CreateProfileRequestClass(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CreateProfileRequestClass{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
