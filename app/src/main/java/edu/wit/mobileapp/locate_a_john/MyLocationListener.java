package edu.wit.mobileapp.locate_a_john;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

public class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location loc){
        Log.v("loc" ,  new Double(loc.getLatitude()).toString()+ " , " + new Double(loc.getLongitude()).toString());
    }

    public void onProviderDisabled(String provider){}

    public void onProviderEnabled(String provider){}

    public void onStatusChanged(String provider , int status , Bundle extras){}
}
