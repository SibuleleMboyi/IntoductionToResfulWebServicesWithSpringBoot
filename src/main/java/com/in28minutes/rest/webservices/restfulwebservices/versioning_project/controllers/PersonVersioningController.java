package com.in28minutes.rest.webservices.restfulwebservices.versioning_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.versioning_project.models.*;

@RestController
public class PersonVersioningController {

    // Test these endpoints on the Thunder Client (Postman extention on VC Code)
    // under "Headers", create a key with "X-API-VERSION" and type the version
    // number in the
    // value field.

    // http://localhost:8080/person/header
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    // http://localhost:8080/person/header
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
