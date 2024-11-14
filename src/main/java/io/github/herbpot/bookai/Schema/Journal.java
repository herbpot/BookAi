package io.github.herbpot.bookai.Schema;

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

    public Journal(String t, String a, String c, String b) {
        title = t;
        author = a;
        content = c;
        bookId = b;
    }

    public List<String> get() {
        return Arrays.asList(new String[]{title, author, bookId, content});
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return title + "|" + author + "|" + content + "|" + bookId;
    }
}
