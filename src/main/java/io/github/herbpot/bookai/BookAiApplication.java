package io.github.herbpot.bookai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class BookAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAiApplication.class, args);
    }

}
