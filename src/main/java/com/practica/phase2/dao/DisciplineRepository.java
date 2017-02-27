package com.practica.phase2.dao;

import com.practica.phase2.model.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by student on 2/27/2017.
 */
@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {

}
