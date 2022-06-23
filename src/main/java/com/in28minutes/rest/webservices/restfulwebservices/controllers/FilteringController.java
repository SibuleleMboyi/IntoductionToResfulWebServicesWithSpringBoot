package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.restfulwebservices.models.*;

@RestController
public class FilteringController {

    // static filtering at Field Level
    @GetMapping("/filtering-static-field-level")
    public SomeBean1 retrieveSomeBeanFilterFieldLevel() {
        return new SomeBean1("value11", "value12", "value13");
    }

    // static filtering at Field Level
    @GetMapping("/filtering-static-class-level")
    public SomeBean1 retrieveSomeBeanFilterClassLevel() {
        return new SomeBean1("value11", "value12", "value13");
    }

    // static filtering at both Field Level and Class Level
    @GetMapping("/filtering-list")
    public List<Object> retrieveListOfSomeBeans() {
        return Arrays.asList(
                new SomeBean1("value21", "value22", "value23"),
                new SomeBean2("value11", "value12", "value13"));
    }

    // dynamic filtering
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBeanDynamicFilter() {
        SomeBean3 someBean3 = new SomeBean3("value31", "value32", "value33");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean3);
        mapping.setFilters(filters);

        return mapping;
    }

}
