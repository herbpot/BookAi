package io.github.herbpot.bookai.schema;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collation = "bookai")
public class Journal {
    @Id
    private String id;
    private String title;
    private String author;
    private String content;
    private String bookId;

    public List<String> get() {
        return Arrays.asList(new String[]{title, author, bookId, content});
    }
}
