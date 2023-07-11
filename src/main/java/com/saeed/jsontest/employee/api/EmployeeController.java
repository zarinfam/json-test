package com.saeed.jsontest.employee.api;

import com.saeed.jsontest.employee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @GetMapping("/{employeeId}")
    public Mono<Employee> getEmployee(@PathVariable Long employeeId) {
        throw new UnsupportedOperationException();
    }

}
