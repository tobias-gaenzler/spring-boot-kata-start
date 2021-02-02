package de.tobiasgaenzler.springbootkatastart;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.mockito.Mockito.*;

public class BirthdayServiceTest {

    @Test
    public void shouldSentGreetingToEmployeesWithBirthdayToday() {
        EmployeeRepository repoMock = mock(EmployeeRepository.class);
        EmailService emailServiceMock = mock(EmailService.class);
        when(repoMock.getEmployees()).thenReturn(List.of(
                new Employee("Doe", "John", LocalDate.now(), "john@doe.com"),
                new Employee("Doe", "Jane", LocalDate.now().minus(1, ChronoUnit.DAYS), "jane@doe.com")
                )
        );

        BirthdayService birthdayService = new BirthdayService(repoMock, emailServiceMock);
        birthdayService.sendBirthdayGreetings();

        verify(emailServiceMock).send("john@doe.com", BirthdayService.SUBJECT, "Happy birthday, dear John!");
        verify(emailServiceMock,never()).send("jane@doe.com", BirthdayService.SUBJECT, "Happy birthday, dear Jane!");
    }
}