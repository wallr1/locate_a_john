package edu.wit.mobileapp.locate_a_john;

import com.google.android.gms.maps.model.LatLng;

public class Bathroom {
    private String name;
    private LatLng loc;

    public Bathroom(String name , LatLng loc){
        this.name = name;
        this.loc = loc;
    }

    public void setLoc(LatLng loc){
        this.loc = loc;
    }

    public LatLng getLoc() {
        return loc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
