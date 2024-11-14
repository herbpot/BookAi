package io.github.herbpot.bookai.Repository;

import io.github.herbpot.bookai.Schema.Book;
import io.github.herbpot.bookai.Schema.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
    @Query("{'title':  ?0}")
    Book findJournalByTitle(String title);
    @Query("{'id':  ?0}")
    Book findJournalById(String id);
}
