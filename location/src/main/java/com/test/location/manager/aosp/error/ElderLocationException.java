package com.test.location.manager.aosp.error;


import android.location.Location;

public class ElderLocationException extends RuntimeException {
    private final Location location;

    public ElderLocationException(Location location) {
        super("The location is too old");
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
