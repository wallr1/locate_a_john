package edu.wit.mobileapp.locate_a_john;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bathroom {
    private double overallRating;
    private String name;
    private LatLng loc;
    private String address;
    private ArrayList<Integer> tags = new ArrayList<Integer>();
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Bathroom(Context context , String name , String adr , int[] tags , int[] ratings){
        this.name = name;
        this.address = adr;
        setTags(tags);
        setRatings(ratings);
        calculateOverallRating();
        getLocFromAddress(context);
    }

    /*
    Re-calculates, sets, and returns overall rating based on class ratings array
     */
    public double calculateOverallRating(){
        if(ratings.size() <= 0){
            this.overallRating = 0;
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < ratings.size(); i++){
            sum += ratings.get(i);
        }
        this.overallRating = (double) sum / ratings.size();
        return this.overallRating;
    }

    private LatLng getLocFromAddress(Context context){

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(this.address, 3);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }
        this.loc = p1;
        return p1;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setTags(int [] tags){
        for (int i = 0; i < tags.length; i++){
            this.tags.add(tags[i]);
        }
    }

    public int[] getTags(){
        int[] tagArray = new int[this.tags.size()];
        for (int i = 0; i < tags.size(); i++){
            tagArray[i] = (int) this.tags.get(i);
        }
        return tagArray;
    }

    public void setRatings(int[] ratings){
        for (int i = 0; i < ratings.length; i++){
            this.ratings.add(ratings[i]);
        }
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
