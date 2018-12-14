package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public List<Person> findBySurnameIgnoreCaseContaining(String filter) {
        return personRepo.findBySurnameIgnoreCaseContaining(filter);
    }
}
