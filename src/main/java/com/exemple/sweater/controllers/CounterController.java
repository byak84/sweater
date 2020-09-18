package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Counter;
import com.exemple.sweater.repos.CounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CounterController {
    @Autowired
    CounterRepo counterRepo;
    @GetMapping("/counters")
    public String CountersList (Model model) {
        List<Counter> counters = counterRepo.findAll();
        model.addAttribute("counters", counters);
        return "counters.html";
    }
}
