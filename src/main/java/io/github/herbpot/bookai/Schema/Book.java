package io.github.herbpot.bookai.Schema;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "bookai")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
