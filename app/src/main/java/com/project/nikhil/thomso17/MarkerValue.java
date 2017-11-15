package com.project.nikhil.thomso17;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by nikhil on 9/10/17.
 */

public class MarkerValue {
    private LatLng latLng;
    private String title;

    public MarkerValue(LatLng latLng, String title) {
        this.latLng = latLng;
        this.title = title;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

