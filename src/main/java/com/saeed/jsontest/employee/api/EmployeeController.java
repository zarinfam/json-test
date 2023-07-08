package com.saeed.jsontest.employee.api;

import com.saeed.jsontest.employee.model.Employee;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @GetMapping("{employeeId}")
    public Mono<Employee> submitOrder(@RequestParam UUID employeeId) {
        return Mono.empty();
    }


}
