package de.tobiasgaenzler.springbootkatastart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final static Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void send(String recipient, String subject, String content) {
        logger.info("Sending email to {} with subject {} and content {}", recipient, subject, content);
        // we do not send email in a small kata like this.
    }
}
