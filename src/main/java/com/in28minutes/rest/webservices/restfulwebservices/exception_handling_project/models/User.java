package com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past
    private Date birthDate;

    protected User() {
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

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
        return String.format("User [id : %s, name : %s, birthDate : %s ]", id, name, birthDate);
    }

    // my customization of an empty User
    public static User emptyUser() {
        return new User(null, null, null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == User.emptyUser() || this.getClass() != obj.getClass())
            return false;

        User user = (User) obj;

        return this.id.equals(user.id) && this.name.equals(user.name) && this.birthDate.equals(user.birthDate);
    }
}
