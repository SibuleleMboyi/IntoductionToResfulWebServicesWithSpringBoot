package com.in28minutes.rest.webservices.restfulwebservices.models;

import java.util.Date;

public class User {

    protected User() {
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    private Integer id;
    private String name;
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setbirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id : %s, name : %s,  birthDate : %s ]", id, name, birthDate);
    }

    // my customization of an empty User
    public static User emptyUser() {
        return new User(null, null, null);
    }

}
