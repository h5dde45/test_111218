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

    @GetMapping("b")
    public String xob() {
        return "xob";
    }

    private String checkHod(int hod, boolean b) {
        if (b) {
            if (hod % 2 == 0) {
                return "Выиграл 1 игрок";
            } else {
                return "Выиграл 2 игрок";
            }
        } else {
            return "";
        }
    }

    @GetMapping(value = "a/{num}/{hod}")
    @ResponseBody
    public String xoaG(@PathVariable int num,
                       @PathVariable int hod) {
        boolean b = xo_service.checkWinner(num, hod);
        return checkHod(hod, b);
    }

    @GetMapping(value = "b/{num}/{hod}")
    @ResponseBody
    public String xobG(@PathVariable int num,
                       @PathVariable int hod) {
        boolean b = xo_service.checkWinner(num, hod);
        return checkHod(hod, b);
    }

    @GetMapping(value = "b/ai")
    @ResponseBody
    public String xobGai() {
        return xo_service.bai();
    }
}
