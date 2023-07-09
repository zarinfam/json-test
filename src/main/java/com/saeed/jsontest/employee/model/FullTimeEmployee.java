package com.saeed.jsontest.employee.model;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(Long employeeId, double salary) {
        super(employeeId);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
