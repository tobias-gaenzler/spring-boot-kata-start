package de.tobiasgaenzler.springbootkatastart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BirthdayService {
    public static final String SUBJECT = "Happy birthday!";
    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;

    @Autowired
    public BirthdayService(EmployeeRepository employeeRepository, EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    public void sendBirthdayGreetings() {
        employeeRepository.getEmployees()//
                .stream()//
                .filter(employee -> {
                            LocalDate today = LocalDate.now();
                            LocalDate birthday = employee.getBirthday();
                            return birthday.getMonth() == today.getMonth() &&
                                    birthday.getDayOfMonth() == today.getDayOfMonth();
                        }
                )//
                .forEach(employee ->
                        emailService.send(employee.getEmail(), SUBJECT, "Happy birthday, dear " + employee.getFirstName() + "!"));
    }
}
