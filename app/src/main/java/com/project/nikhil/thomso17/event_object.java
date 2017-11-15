package com.project.nikhil.thomso17;

import java.io.Serializable;

/**
 * Created by nikhil on 8/10/17.
 */

public class event_object implements Serializable {

    String id,name,venue,start_time,end_time,lat,lng,coord,coord_no,description,rulebook,day,date;

    public event_object(String id, String name, String venue, String start_time, String end_time, String lat, String lng, String coord, String coord_no, String description, String rulebook, String day, String date) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.start_time = start_time;
        this.end_time = end_time;
        this.lat = lat;
        this.lng = lng;
        this.coord = coord;
        this.coord_no = coord_no;
        this.description = description;
        this.rulebook = rulebook;
        this.day = day;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getCoord_no() {
        return coord_no;
    }

    public void setCoord_no(String coord_no) {
        this.coord_no = coord_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRulebook() {
        return rulebook;
    }

    public void setRulebook(String rulebook) {
        this.rulebook = rulebook;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
