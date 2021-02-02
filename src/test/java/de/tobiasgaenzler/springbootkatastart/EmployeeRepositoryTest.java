package de.tobiasgaenzler.springbootkatastart;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepositoryTest {

    @Test
    public void shouldLoadEmployeesFromFile() {
        EmployeeRepository repo = new EmployeeRepository("test_employee_data.txt");
        List<Employee> employees = repo.getEmployees();
        assertThat(employees).containsExactly(
                new Employee("Doe", "John", LocalDate.of(1982, 2, 1), "john.doe@foobar.com"),
                new Employee("Doe", "Jane", LocalDate.of(1975, 3, 11), "jane@doe.com")
        );
    }
}