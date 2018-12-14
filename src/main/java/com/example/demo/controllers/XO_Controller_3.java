package com.example.demo.controllers;

import com.example.demo.service.XO_Service_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xo/c")
public class XO_Controller_3 {
    @Autowired
    private XO_Service_3 xo_service_3;

    @GetMapping()
    public String xoc(Model model) {
        xo_service_3.update();
        model.addAttribute("cards", xo_service_3.getCards());
        return "xoc";
    }

    @GetMapping("{id}")
    public String xobIdC(@PathVariable Integer id, Model model) {
        xo_service_3.addPlayer(id);
        model.addAttribute("cards", xo_service_3.getCards());
        return "xoc";
    }

    @GetMapping("update")
    public String updateC() {
        xo_service_3.update();
        return "redirect:";
    }
}
