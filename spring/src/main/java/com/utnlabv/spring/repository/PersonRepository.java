package com.utnlabv.spring.repository;

import com.utnlabv.spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query(value = "select * from person where name like %?1%", nativeQuery = true)
    List<Person> findByName(String name);

    @Query(value = "select * from person where age = ?1", nativeQuery = true)
    List<Person> findByAge(Integer age);
}