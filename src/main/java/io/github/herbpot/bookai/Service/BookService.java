package io.github.herbpot.bookai.Service;

import io.github.herbpot.bookai.Repository.BookRepository;
import io.github.herbpot.bookai.Schema.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public Book getBookById(String id) {
        return bookRepository.findBookById(id);
    }
}
