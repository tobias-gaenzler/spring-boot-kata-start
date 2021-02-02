package de.tobiasgaenzler.springbootkatastart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class BirthdayGreetingRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(BirthdayGreetingRunner.class);

    private final BirthdayService birthdayService;

    @Autowired
    public BirthdayGreetingRunner(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @Override
    public void run(ApplicationArguments args) {
        logger.info("Starting to send greetings ...");
        birthdayService.sendBirthdayGreetings();
        logger.info("Finished sending greetings ...");
    }
}
