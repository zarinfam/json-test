package com.saeed.jsontest.employee.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.saeed.jsontest.employee.model.validator.PersonnelNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

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

    @Email(message = "The email format is incorrect.")
    @NotEmpty(message = "The email can not be empty.")
    private String email;

    @PersonnelNumber(message = "The personnel number format is incorrect.")
    private String personnelNumber;

    public Employee() {
    }

    public Employee(Long employeeId, String email, String personnelNumber) {
        this.employeeId = employeeId;
        this.email = email;
        this.personnelNumber = personnelNumber;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }
}
