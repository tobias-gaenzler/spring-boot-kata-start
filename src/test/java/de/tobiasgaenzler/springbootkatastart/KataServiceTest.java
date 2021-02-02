package de.tobiasgaenzler.springbootkatastart;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.mockito.Mockito.*;

public class KataServiceTest {

    @Test
    public void shouldDoKata() {
        KataService kataService = new KataService();
        kataService.doKata();
        // TODO: verify result or actions
    }
}