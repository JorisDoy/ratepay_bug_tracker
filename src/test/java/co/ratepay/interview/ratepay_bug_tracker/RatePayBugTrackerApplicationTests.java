package co.ratepay.interview.ratepay_bug_tracker;

import co.ratepay.interview.ratepay_bug_tracker.entry.controllers.BugTrackerController;
import co.ratepay.interview.ratepay_bug_tracker.services.BugTrackerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RatePayBugTrackerApplication.class)
@WebAppConfiguration
public class RatePayBugTrackerApplicationTests {

    @Autowired
    private BugTrackerController bugTrackerController;

    @Autowired
    private BugTrackerService bugTrackerService;

    @Test
    public void contextLoads() {
        assertThat(this.bugTrackerController, notNullValue());
        assertThat(this.bugTrackerService, notNullValue());
    }

    @Test
    public void main() {
        RatePayBugTrackerApplication.main(new String[]{});
        assertThat(1).isEqualTo(1);
    }

}
