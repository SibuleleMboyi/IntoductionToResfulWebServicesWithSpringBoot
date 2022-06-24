package com.in28minutes.rest.webservices.restfulwebservices.hello_world_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.hello_world_project.models.HelloWorldBean;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
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

    // Internationalization( refered as i18n(because of it character length) ).
    // It helps to customize services for different consumers around the world.
    // It customizes services across different languages.
    // Create a "properties" file to store customized information.
    // name it "messages.properties" for English.
    // name another one "messages_fr.properties" for French
    // (google other naming conventions).
    // After running the App,
    // select a GET request and enter this end point URL,
    // select hearders and add, "Accept-Language",
    // then enter abbreviation e.g nl, fr, eng from these file
    // names(messages_fr.properties).
    // Send the request.
    @GetMapping(path = "/hello-world-internationalized")
    public String hellowWorldInternationalized() {

        return messageSource.getMessage("good.morning.message", null,
                "Default Message",
                LocaleContextHolder.getLocale());
    }
}
