package com.example.demo.repos;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findBySurnameIgnoreCaseContaining(String surname);
}
