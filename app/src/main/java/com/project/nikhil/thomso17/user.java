package com.project.nikhil.thomso17;

import java.io.Serializable;

/**
 * Created by nikhil on 6/10/17.
 */

public class user implements Serializable{
String token;
    String address;
    String college;//
    String contact;//
    String email;//
    String gender;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    String name; //
    String image;
    String event;

    public user(String token, String address, String college, String contact, String email, String gender, String name, String image, String event, String id) {
        this.token = token;
        this.address = address;
        this.college = college;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.image = image;
        this.event = event;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public user(String token, String address, String college, String contact, String email, String gender, String name, String image, String id) {

        this.token = token;
        this.address = address;
        this.college = college;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.image = image;
        this.id = id;
    }

    String id;//

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

