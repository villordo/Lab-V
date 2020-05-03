package com.utnlabv.spring.controller;

import com.utnlabv.spring.model.Person;
import com.utnlabv.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RestController//avisa que la clase es un controller
@RequestMapping("/person")//indica una ruta general a la clase
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personID}")
    public Person getPersonByID(@PathVariable Integer personID ){
        return personService.getPersonByID(personID);
    }

    @GetMapping("/")
    public List<Person> getPersons(@RequestParam(required = false) String name,Integer age){
        return personService.getPersons(name,age);
    }

    @PostMapping("/")
    public void addPerson(@RequestBody @Valid Person person){
        personService.add(person);
    }

}