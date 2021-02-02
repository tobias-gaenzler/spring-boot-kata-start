package de.tobiasgaenzler.springbootkatastart;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final LocalDate birthday;
    private final String email;

    public Employee(String lastName, String firstName, LocalDate birthday, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) &&
                Objects.equals(birthday, employee.birthday) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, birthday, email);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }
}
