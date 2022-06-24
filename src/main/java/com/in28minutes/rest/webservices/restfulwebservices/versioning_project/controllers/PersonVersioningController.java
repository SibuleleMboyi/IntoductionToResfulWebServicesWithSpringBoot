package com.in28minutes.rest.webservices.restfulwebservices.versioning_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.versioning_project.models.*;

@RestController
public class PersonVersioningController {

    // Produces versioning is also called ACCEPT HEADER VERSIONING

    // Test these endpoints on the Thunder Client (Postman extention on VC Code)
    // under "Accept", create a key with "application/vnd.company.app-v1+json"
    // (with no quotation marks) and type the version number in the value field.

    // http://localhost:8080/person/produces
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    // http://localhost:8080/person/produces
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
