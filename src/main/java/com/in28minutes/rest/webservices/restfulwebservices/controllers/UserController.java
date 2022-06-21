package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.models.User;
import com.in28minutes.rest.webservices.restfulwebservices.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    // Addition of Hateoas
    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userRepository.getUser(id);

        System.out.println(user);
        if (user.equals(User.emptyUser())) {
            throw new UserNotFoundException("id : " + id);
        }

        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());

        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    // To set the status , URI of the created User and other
    // parameters into the returned Response,
    // We make use of ResponseEntity class.
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userRepository.saveUser(user);

        // Creates the URI of the resource that has been created,
        // from the current "/users" URI.
        // We do not want to hardcode "/users".
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userRepository.deleteUser(id);

        System.out.println("user :::::::::::::::::::::::::::::");

        if (user.equals(User.emptyUser())) {
            System.out.println(user);

            throw new UserNotFoundException("id : " + id);
        }
    }
}
