package edu.wit.mobileapp.locate_a_john;

import com.google.android.gms.maps.model.LatLng;

public class Bathroom {
    private String name;
    private LatLng loc;
    private String city = "";

    public Bathroom(String name , LatLng loc){
        this.name = name;
        this.loc = loc;
    }

    public Bathroom (String name , LatLng loc , String city){
        this.name = name;
        this.loc = loc;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }
}
