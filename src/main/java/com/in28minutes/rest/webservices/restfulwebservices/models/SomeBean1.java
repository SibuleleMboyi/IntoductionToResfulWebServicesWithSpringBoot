package com.in28minutes.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

// The type of filtering used here is called STATIC FILTERING.
// It is because it cannot be changed at Run time.
// Mostly prefered one as it helps to avoids inconsistency and having to do lots
// of changes when variables are changed.
// Filtering is done at the Field Level
public class SomeBean1 extends BaseSomeBean {

    @JsonIgnore
    private String field3;

    public SomeBean1(String field1, String field2, String field3) {
        super(field1, field2, field3);
    }

}
