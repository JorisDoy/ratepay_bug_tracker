package co.ratepay.interview.ratepay_bug_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatePayBugTrackerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RatePayBugTrackerApplication.class);
        springApplication.setAddCommandLineProperties(false);
        springApplication.run();
    }

}
