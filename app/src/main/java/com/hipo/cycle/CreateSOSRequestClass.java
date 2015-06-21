package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */


public class CreateSOSRequestClass {
    private Owner owner ;
    private Location location;

    public CreateSOSRequestClass(Owner owner,Location location) {
        this.owner = owner;
        this.location = location;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CreateSOSRequestClass{" +
                "owner=" + owner +
                '}';
    }
}
