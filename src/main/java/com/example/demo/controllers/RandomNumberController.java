package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomNumberController {

    @GetMapping("/random_number")
    private String rand() {
        return "randomnumber";
    }

    @GetMapping("/random_number/g")
    private String randG(Model model) {
        model.addAttribute("number", (int) (Math.random() * 1e9));
        return "randomnumber";
    }
}
