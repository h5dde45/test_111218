package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/keymouse")
public class Controller_KeyMouse {
    @GetMapping
    public String keymouse() {
        return "keyboard _and_mouse_tester";
    }

    @GetMapping(value = "k/{num}")
    @ResponseBody
    public String keyNum(@PathVariable int num) {
        return "Number pressed: [" + (num - 48) + "]";
    }

    @GetMapping(value = "m/{x}/{y}")
    @ResponseBody
    public String mNum(@PathVariable int x,
                       @PathVariable int y) {
        return "Mouse clicked: [X:" + x + "; Y:" + y + "]";
    }
}
