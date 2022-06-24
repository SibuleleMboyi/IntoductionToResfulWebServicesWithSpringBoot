package com.in28minutes.rest.webservices.restfulwebservices.versioning_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.versioning_project.models.*;

@RestController
public class PersonVersioningController {

    // http://localhost:8080/person/param?version=1
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    // http://localhost:8080/person/param?version=2
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
