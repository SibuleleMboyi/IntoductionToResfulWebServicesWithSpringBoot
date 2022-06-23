package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.models.SomeBean1;
import com.in28minutes.rest.webservices.restfulwebservices.models.SomeBean2;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean1 retrieveSomeBean() {
        return new SomeBean1("value11", "value12", "value13");
    }

    @GetMapping("/filtering-list")
    public List<Object> retrieveListOfSomeBeans() {
        return Arrays.asList(
                new SomeBean2("value21", "value22", "value23"),
                new SomeBean1("value11", "value12", "value13"),
                new SomeBean2("value21", "value22", "value23"));
    }
}
