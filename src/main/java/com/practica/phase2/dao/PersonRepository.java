package com.practica.phase2.dao;

import com.practica.phase2.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2/22/2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
