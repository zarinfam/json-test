package com.saeed.jsontest.employee.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FullTimeEmployee.class, name = "fulltime"),
        @JsonSubTypes.Type(value = HourlyEmployee.class, name = "hourly")
})
public abstract class Employee {
}
