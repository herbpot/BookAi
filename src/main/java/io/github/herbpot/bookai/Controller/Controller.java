package io.github.herbpot.bookai.controller;

import io.github.herbpot.bookai.schema.Journal;
import io.github.herbpot.bookai.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @GetMapping("/journals")
    public String getJournals(Model model) {
        List<Journal> journals = journalRepository.findAll();
        model.addAttribute("journals", journals);
        return "journals";
    }
}
