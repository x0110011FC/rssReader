package application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    private final FeedRepository repository;

    public FeedController(FeedRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/feeds")
    List<Feed> allFeeds() {
        return repository.findAll();
    }

    @GetMapping("/limited")
    List<Feed> limitedFeeds() {
        return repository.findTop10ByOrderByIdDesc();
    }
}
