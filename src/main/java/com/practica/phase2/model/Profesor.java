package com.practica.phase2.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@DiscriminatorValue("P")
public class Profesor extends Person {
  private Double salary;
  private Collection<Discipline> disciplines;
  private Collection<Mark> marks;

  @Basic
  @Column(name = "salary", nullable = true, precision = 0)
  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @OneToMany(mappedBy = "profesor")
  public Collection<Discipline> getDisciplines() {
    return disciplines;
  }

  public void setDisciplines(Collection<Discipline> disciplinesByIdProfesor) {
    this.disciplines = disciplinesByIdProfesor;
  }

  @OneToMany(mappedBy = "profesor")
  public Collection<Mark> getMarks() {
    return marks;
  }

  public void setMarks(Collection<Mark> marksByIdProfesor) {
    this.marks = marksByIdProfesor;
  }

}
