package de.tobiasgaenzler.springbootkatastart;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Test that the application is able to start (load spring context)
 */
@ActiveProfiles("test")
@SpringBootTest
public class KataApplicationTests {

	@Test
	void contextLoads() {
	}

}
