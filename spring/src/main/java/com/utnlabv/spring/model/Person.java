package com.utnlabv.spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Entity //Entidad de persistencia
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @Id //primary key
    @GeneratedValue //autoincrement de bdd
    private Integer ID;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;

    //TODO
    //agregar un filter nuevo
    //private Integer age;
}