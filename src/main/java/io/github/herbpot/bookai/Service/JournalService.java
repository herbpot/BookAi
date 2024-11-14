package io.github.herbpot.bookai.Service;

import io.github.herbpot.bookai.Repository.BookRepository;
import io.github.herbpot.bookai.Repository.JournalRepository;
import io.github.herbpot.bookai.Schema.Book;
import io.github.herbpot.bookai.Schema.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public Book geJournalById(String id) {
        return journalRepository.findJournalById(id);
    }

    public void insertJournal(Journal journal) {
        mongoTemplate.insert(journal);
    }
}
