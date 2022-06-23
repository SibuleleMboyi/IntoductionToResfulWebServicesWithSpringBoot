package com.in28minutes.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

// The type of filtering used here is called STATIC FILTERING.
// It is because it cannot be changed at Run time.
public class SomeBean1 {
    private String field1;
    private String field2;

    // Mostly prefered one as it helps to avoids inconsistency and having to do lots
    // of changes
    // when variables are changed.
    @JsonIgnore
    private String field3;

    public SomeBean1(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

}
