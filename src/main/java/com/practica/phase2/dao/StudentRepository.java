package com.practica.phase2.dao;

import com.practica.phase2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by student on 2/21/2017.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
