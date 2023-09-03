package com.saeed.jsontest.employee.api;

import com.saeed.jsontest.employee.model.Employee;
import com.saeed.jsontest.employee.model.FullTimeEmployee;
import com.saeed.jsontest.employee.model.HourlyEmployee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@JsonTest
class EmployeeJsonTest {

    @Autowired
    private JacksonTester<Employee> jacksonTester;

    @ParameterizedTest
    @MethodSource("employeeJsonTestCases")
    void employee_serialize_successfully(Employee employee, String expectedJson) throws Exception {
        //Given employee

        //When
        var serializedJson = jacksonTester.write(employee);

        //Then
        assertThat(serializedJson)
                .isEqualToJson(expectedJson);
    }

    @ParameterizedTest
    @MethodSource("employeeJsonTestCases")
    void employee_deserialize_successfully(Employee expectedEmployee, String jsonString) throws Exception {
        //Given jsonString

        //When
        var parsedJson = jacksonTester.parse(jsonString);

        //Then
        assertThat(parsedJson)
                .usingRecursiveComparison()
                .isEqualTo(expectedEmployee);
    }

    private static Stream<Arguments> employeeJsonTestCases() {
        return Stream.of(
                arguments(new FullTimeEmployee(1L, "zarinfam.s@gmail.com", "12-321", 1012.32), """
                        {
                             "employeeId": 1,
                             "email": "zarinfam.s@gmail.com",
                             "personnelNumber": "12-321",
                             "salary": 1012.32,
                             "type": "fulltime"
                        }
                        """),
                arguments(new HourlyEmployee(2L, "saeed.zarinfam@gmail.com", "12-322", 1000.0, 160), """
                        {
                             "employeeId": 2,
                             "email": "saeed.zarinfam@gmail.com",
                             "personnelNumber": "12-322",
                             "hourlyRate": 1000.0,
                             "hoursWorked": 160,
                             "type": "hourly"
                        }
                        """)
        );
    }

    //todo: missing type in json (failed test)
}
