package com.example.demo.controllers;

import com.example.demo.service.XO_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xo")
public class XO_Controller {
    @Autowired
    private XO_Service xo_service;

    @GetMapping
    public String xo() {
        return "xo";
    }

    @GetMapping("a")
    public String xoa() {
        return "xoa";
    }

    @GetMapping(value = "a/{num}/{hod}")
    @ResponseBody
    public String xoaG(@PathVariable int num,
                       @PathVariable int hod) {
        boolean b = xo_service.checkWinner(num, hod);
        return xo_service.checkHod(hod, b);
    }

}
