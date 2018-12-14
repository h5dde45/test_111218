package com.example.demo.controllers;

import com.example.demo.domain.Person;
import com.example.demo.repos.PersonRepo;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepo personRepo;

    @GetMapping
    public String main(@RequestParam(required = false) String filter,
                       Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("persons", personService.findBySurnameIgnoreCaseContaining(filter));
        } else {
            model.addAttribute("persons", personService.findAll());
        }
        return "personList";
    }

    @GetMapping("{person}")
    public String editPerson(@PathVariable Person person,
                             Model model) {
        model.addAttribute("person", person);
        model.addAttribute("persons", personService.findAll());
        return "personList";
    }

    @GetMapping("delete/{person}")
    public String deletePerson(@PathVariable Person person,
                             Model model) {
        personRepo.delete(person);
        model.addAttribute("person", null);
        model.addAttribute("persons", personService.findAll());
        return "personList";
    }

    @PostMapping
    public String add(Person person, Model model) {
        personRepo.save(person);
        model.addAttribute("person", null);
        model.addAttribute("persons", personService.findAll());
        return "personList";
    }

    @PostMapping("{person}")
    public String add(@PathVariable Person person,
                      @RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      @RequestParam("telephone") String telephone,
                      Model model) {
        person.setName(name);
        person.setSurname(surname);
        person.setTelephone(telephone);
        personRepo.save(person);
        model.addAttribute("person", null);
        model.addAttribute("persons", personService.findAll());
        return "personList";
    }
}
