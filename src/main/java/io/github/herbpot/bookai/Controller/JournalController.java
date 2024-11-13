package io.github.herbpot.bookai.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

public class JournalController {
    private static final Logger logger = Logger.getLogger(JournalController.class.getName());

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String WriteJournal() {
        logger.info("Writing journal");

        return "redirect:/";
    }
}
