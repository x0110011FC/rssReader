package application;

import com.sun.syndication.io.FeedException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RssReaderTest {

    private static final Logger log = LoggerFactory.getLogger(RssReaderTest.class);

    @Test
    void readFeed() {
        String feed = "https://www.nasa.gov/rss/dyn/breaking_news.rss";
        try {
            assertNotNull(RssReader.readFeed(feed));
        } catch (IOException e) {
            log.error("Cannot read feed - {}", e);
        } catch (FeedException e) {
            log.error("Something bad happens with feed - {}", e);
        }
    }
}