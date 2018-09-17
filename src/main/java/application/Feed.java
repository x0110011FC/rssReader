package application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String feedData;

    public Feed() {
    }

    public Feed(String feedData) {
        this.feedData = feedData;
    }
}
