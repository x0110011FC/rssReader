package application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeedControllerTest {
    private static final Logger log = LoggerFactory.getLogger(FeedControllerTest.class);

    @Autowired
    private TestRestTemplate template;

    @Test
    void all() {
        String feedContent = this.template.getForObject("/feeds", String.class);
        assertNotNull(feedContent);

    }

    @Test
    void limited() {
        List<String> feeds = this.template.getForObject("/limited", List.class);
        assertTrue(feeds.size() == 10);
    }
}