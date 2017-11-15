package com.project.nikhil.thomso17;

/**
 * Created by nikhil on 6/10/17.
 */

public class team_member {

    String name,post,email,phone,image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone() {
        return phone;

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public team_member(String name, String post, String email, String phone, String image) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }
}
   