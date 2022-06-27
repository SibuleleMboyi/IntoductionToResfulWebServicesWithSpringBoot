package com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    private Integer id;

    @GeneratedValue
    private String description;

    // Defines that data should be lazily fetched, i.e fetched on demand.
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("User [id : %s, description : %s, user : %s ]",
                id, description, user);
    }

}
