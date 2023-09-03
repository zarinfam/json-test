package com.saeed.jsontest.employee.api.model;

import com.saeed.jsontest.employee.model.Employee;
import com.saeed.jsontest.employee.model.FullTimeEmployee;
import com.saeed.jsontest.employee.model.HourlyEmployee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest(classes = {ValidationAutoConfiguration.class})
class EmployeeValidationTest {

    @Autowired
    private Validator validator;

    @ParameterizedTest
    @MethodSource("employeeValidationSuccessTestCases")
    void employee_validate_successfully(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        assertThat(violations).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("employeeValidationEmailFailTestCases")
    void employeeWithWrongEmail_validation_fail(Employee employee, String errorMessage) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo(errorMessage);
    }

    private static Stream<Arguments> employeeValidationSuccessTestCases() {
        return Stream.of(
                arguments(new FullTimeEmployee(1L, "zarinfam.s@gmail.com", "12-321", 1012.32)),
                arguments(new HourlyEmployee(2L, "saeed.zarinfam@gmail.com", "12-322", 1000.0, 160))
        );
    }

    private static Stream<Arguments> employeeValidationEmailFailTestCases() {
        return Stream.of(
                arguments(new FullTimeEmployee(1L, "", "12-321", 1012.32),
                        "The email can not be empty."),
                arguments(new HourlyEmployee(2L, "saeed.zarinfamgmail.com", "12-322", 1000.0, 160),
                        "The email format is incorrect.")
        );
    }

    //todo: Write more failed tests
}
