package co.ratepay.interview.ratepay_bug_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Rate pay bug tracker application.
 */
@SpringBootApplication
public class RatePayBugTrackerApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RatePayBugTrackerApplication.class);
        springApplication.setAddCommandLineProperties(false);
        springApplication.run();
    }

}
