package co.ratepay.interview.ratepay_bug_tracker;

import co.ratepay.interview.ratepay_bug_tracker.models.pojos.BugRequest;
import co.ratepay.interview.ratepay_bug_tracker.services.BugTrackerService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

/**
 * The type Bug tracker integration unit tests.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RatePayBugTrackerApplication.class)
@WebAppConfiguration
public class BugTrackerIntegrationUnitTests {
    private static final Logger LOGGER = Logger.getLogger( BugTrackerIntegrationUnitTests.class.getName() );
    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BugTrackerService bugTrackerService;

    private BugRequest bugRequest;

    /**
     * Sets converters.
     *
     * @param converters the converters
     */
    @Autowired
    void setConverters(HttpMessageConverter <?>[] converters) {
        this.mappingJackson2HttpMessageConverter = Arrays.stream( converters )
                .filter( hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse( null );
        assertNotNull( "the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter );
    }

}
