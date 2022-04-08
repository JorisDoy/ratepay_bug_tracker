package co.ratepay.interview.ratepay_bug_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatepayBugTrackerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RatepayBugTrackerApplication.class);
        springApplication.setAddCommandLineProperties(false);
        springApplication.run();
    }

}
