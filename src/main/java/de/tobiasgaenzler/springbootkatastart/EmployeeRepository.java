package de.tobiasgaenzler.springbootkatastart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRepository {
    private final static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final String employeeFileName;

    @Autowired
    public EmployeeRepository(@Value("${kata.employeeFileName:employee_data.txt}") String employeeFileName) {
        this.employeeFileName = employeeFileName;
    }

    public List<Employee> getEmployees() {
        Path employeeFilePath = Path.of(employeeFileName);
        return getEmployeeDataFromFile(employeeFilePath).stream()//
                .map(this::createEmployee)//
                .collect(Collectors.toList());
    }

    private Employee createEmployee(String line) {
        String[] values = line.split(",");
        LocalDate birthday = parseBirthdayStringToLocalDate(values[2].trim());
        return new Employee(values[0].trim(), values[1].trim(), birthday, values[3].trim());
    }

    List<String> getEmployeeDataFromFile(Path employeeFilePath) {
        try {
            // skip headers (first line)
            return Files.readAllLines(employeeFilePath).stream().skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Could not read employee data from file {}", employeeFileName, e);
            throw new RuntimeException(e);
        }
    }

    private LocalDate parseBirthdayStringToLocalDate(String birthdayString) {
        return LocalDate.parse(birthdayString, formatter);
    }
}
