package application;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application {

    // check data from source periodically every x time
    private Long period = 10L;
    // above check time unit
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private String url = "https://www.nasa.gov/rss/dyn/breaking_news.rss";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner demo(FeedRepository repository) {
        return (a) -> {
            SyndFeed feed = RssReader.readFeed(url);

            Runnable runnable = new Runnable() {
                public void run() {
                    for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
                        repository.save(new Feed(DataModifier.replaceNasaWithFbi(entry.getTitleEx().getValue())));
                    }
                }
            };

            ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
            exec.scheduleAtFixedRate(runnable, 0, period, timeUnit);
        };
    }
}