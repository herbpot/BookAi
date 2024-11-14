package io.github.herbpot.bookai.Repository;

import io.github.herbpot.bookai.Schema.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{'title':  ?0}")
    Book findBookByTitle(String title);
    @Query("{'id':  ?0}")
    Book findBookById(String id);
}
