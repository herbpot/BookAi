package io.github.herbpot.bookai.Controller;

import io.github.herbpot.bookai.Schema.Journal;
import io.github.herbpot.bookai.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@   Controller
public class JournalController {
    private static final Logger logger = Logger.getLogger(JournalController.class.getName());
    @Autowired
    JournalService journalService;

    @PostMapping(value = "/write")
    public String WriteJournal(
            @ModelAttribute Journal journal
            ) {
        logger.info("Writing journal");
        logger.info(journal.toString());
        try{
            journalService.insertJournal(journal);
            logger.info("insert success");
        }catch (Exception e){
            logger.warning(e.getMessage());
            throw e;
        }

        return "redirect:/";
    }
}
