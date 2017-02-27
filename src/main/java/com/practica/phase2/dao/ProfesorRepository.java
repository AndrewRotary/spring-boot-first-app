package com.practica.phase2.dao;

import com.practica.phase2.model.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by student on 2/27/2017.
 */
@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {
}
