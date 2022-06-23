package com.in28minutes.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// The type of filtering used here is called STATIC FILTERING.
// It is because it cannot be changed at Run time.
// It's not so preffered as changing variable names affect the hardcoded values inside this filter.
// Filtering is done at the Class Level
@JsonIgnoreProperties(value = { "field1", "field2" })
@SuppressWarnings("unused")
public class SomeBean2 extends BaseSomeBean {

    private String field1;
    private String field2;

    public SomeBean2(String field1, String field2, String field3) {
        super(field1, field2, field3);
    }

}
