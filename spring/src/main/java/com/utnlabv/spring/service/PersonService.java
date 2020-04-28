package com.utnlabv.spring.service;

import com.utnlabv.spring.model.Person;
import com.utnlabv.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired //permite modificar un final(?
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(final Person person){
        personRepository.save(person);
    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public Person getPerson(Integer personId){
        return personRepository.findById(personId).get();
    }

}