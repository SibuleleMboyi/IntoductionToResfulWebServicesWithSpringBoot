package com.in28minutes.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean3 extends BaseSomeBean {

    public SomeBean3(String field1, String field2, String field3) {
        super(field1, field2, field3);
    }

}
