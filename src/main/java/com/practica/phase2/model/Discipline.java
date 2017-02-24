package com.practica.phase2.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
public class Discipline {
  private Integer idDiscipline;
  private String title;
  private Double scholarshipThreshold;
  private Profesor profesor;
  private Collection<DisciplineAverage> disciplineAverage;
  private Collection<Mark> marks;

  @Id
  @Column(name = "id_discipline", nullable = false, insertable = false, updatable = false)
  public Integer getIdDiscipline() {
    return idDiscipline;
  }

  public void setIdDiscipline(Integer idDiscipline) {
    this.idDiscipline = idDiscipline;
  }

  @Basic
  @Column(name = "title", nullable = true, length = -1)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Basic
  @Column(name = "scholarship_threshold", nullable = true, precision = 0)
  public Double getScholarshipThreshold() {
    return scholarshipThreshold;
  }

  public void setScholarshipThreshold(Double scholarshipThreshold) {
    this.scholarshipThreshold = scholarshipThreshold;
  }

  @ManyToOne
  @JoinColumn(name = "id_profesor", referencedColumnName = "id")
  public Profesor getProfesor() {
    return profesor;
  }

  public void setProfesor(Profesor profesorByIdProfesor) {
    this.profesor = profesorByIdProfesor;
  }

  @OneToMany(mappedBy = "discipline")
  public Collection<DisciplineAverage> getDisciplineAverage() {
    return disciplineAverage;
  }

  public void setDisciplineAverage(Collection<DisciplineAverage> disciplineAveragesByIdDiscipline) {
    this.disciplineAverage = disciplineAveragesByIdDiscipline;
  }

  @OneToMany(mappedBy = "discipline")
  public Collection<Mark> getMarks() {
    return marks;
  }

  public void setMarks(Collection<Mark> marksByIdDiscipline) {
    this.marks = marksByIdDiscipline;
  }
}
