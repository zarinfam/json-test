package com.saeed.jsontest.employee.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FullTimeEmployee.class, name = Employee.FULL_TIME),
        @JsonSubTypes.Type(value = HourlyEmployee.class, name = Employee.HOURLY)
})
public abstract class Employee {
    public static final String FULL_TIME = "fulltime";
    public static final String HOURLY = "hourly";

    private Long employeeId;

    public Employee() {
    }

    public Employee(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
