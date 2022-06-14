package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.controllers.models.HelloWorldBean;

@RestController
public class HelloWorldController {

    @GetMapping(path = "hello-world")
    public String hellowWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // e.g "/hello-world/path-variable/in28minutes"
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    // e.g "/hello-world/path-variable?name=in28minutes"
    @GetMapping(path = "/hello-world/path-variable")
    public HelloWorldBean helloWorldBeanRequestParam(@RequestParam String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
