package com.practica.phase2.dao;

import com.practica.phase2.model.Discipline;
import com.practica.phase2.model.DisciplineAverage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2/27/2017.
 */
public interface DisciplineAverageRepository extends CrudRepository<DisciplineAverage, Integer> {
  DisciplineAverage findDisciplineAverageByDiscipline(Discipline discipline);
}
