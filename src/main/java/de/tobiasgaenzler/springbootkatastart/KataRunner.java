package de.tobiasgaenzler.springbootkatastart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Executed on startup in production (but not during tests to avoid unwanted executions and problems with mocks)
 */
@Component
@Profile("!test")
public class KataRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(KataRunner.class);

    private final KataService kataService;

    @Autowired
    public KataRunner(KataService kataService) {
        this.kataService = kataService;
    }

    @Override
    public void run(ApplicationArguments args) {
        logger.info("Starting service execution ...");
        kataService.doKata();
        logger.info("Finished service execution ...");
    }
}
