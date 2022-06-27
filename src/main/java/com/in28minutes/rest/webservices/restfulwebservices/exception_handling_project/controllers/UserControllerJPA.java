package com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models.Post;
import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.repositories.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.repositories.UserRepositoryJPA;

@RestController
public class UserControllerJPA {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> getUsers() {
        return userRepositoryJPA.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> getUser(@PathVariable int id) {
        Optional<User> user = userRepositoryJPA.findById(id);

        System.out.println(user);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id : " + id);
        }

        EntityModel<Optional<User>> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());

        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userRepositoryJPA.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepositoryJPA.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
        Optional<User> userOptional = userRepositoryJPA.findById(id);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("id : " + id);
        }
        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<User> createPost(@Valid @PathVariable int id, @RequestBody Post post) {

        Optional<User> userOptional = userRepositoryJPA.findById(id);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("id : " + id);
        }

        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
