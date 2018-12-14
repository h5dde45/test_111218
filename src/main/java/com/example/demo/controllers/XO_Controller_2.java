package com.example.demo.controllers;

import com.example.demo.service.XO_Service_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xo/b")
public class XO_Controller_2 {
    @Autowired
    private XO_Service_2 xo_service_2;

    @GetMapping
    public String xob(Model model) {
        model.addAttribute("cards", xo_service_2.getCards());
        return "xob";
    }

    @GetMapping("{id}")
    public String xobId(@PathVariable Integer id, Model model) {
        xo_service_2.addPlayer(id);
        model.addAttribute("cards", xo_service_2.getCards());
        return "xob";
    }

    @GetMapping("update")
    public String update() {
        xo_service_2.update();
        return "redirect:";
    }
}
