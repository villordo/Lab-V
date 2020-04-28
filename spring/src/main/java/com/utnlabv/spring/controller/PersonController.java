package com.utnlabv.spring.controller;

import com.utnlabv.spring.model.Person;
import com.utnlabv.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId ){
        return personService.getPerson(personId);
    }

    @GetMapping("/")
    public List<Person> getPerson(){
        return personService.getPerson();
        
    }

    @PostMapping("/")
    public void addPerson(@RequestBody @Valid Person person){
        personService.add(person);
    }
}