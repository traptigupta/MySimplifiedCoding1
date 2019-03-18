package com.example.autotest.simplifiedcoding;

/**
 * Created by AutoTest on 24-Jul-18.
 */

public class User {
    private String username, email,gender;
    private  int id;

    public User(int id,String username, String email,String gender) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.gender=gender;


    }

    public String getUsername() {
        return username;
    }


    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }


}

