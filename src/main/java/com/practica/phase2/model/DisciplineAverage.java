package com.practica.phase2.model;

import javax.persistence.*;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@Table(name = "discipline_average", schema = "public", catalog = "practica")
public class DisciplineAverage {
  private Integer idDisciplineAverage;
  private Double averageMark;
  private Student student;
  private Discipline discipline;

  @Id
  @Column(name = "id_discipline_average", nullable = false, insertable = false, updatable = false)
  public Integer getIdDisciplineAverage() {
    return idDisciplineAverage;
  }

  public void setIdDisciplineAverage(Integer idDisciplineAverage) {
    this.idDisciplineAverage = idDisciplineAverage;
  }

  @Basic
  @Column(name = "average_mark", nullable = true, precision = 0)
  public Double getAverageMark() {
    return averageMark;
  }

  public void setAverageMark(Double averageMark) {
    this.averageMark = averageMark;
  }

  @ManyToOne
  @JoinColumn(name = "id_student", referencedColumnName = "id")
  public Student getStudent() {
    return student;
  }

  public void setStudent(Student studentByIdStudent) {
    this.student = studentByIdStudent;
  }

  @ManyToOne
  @JoinColumn(name = "id_discipline", referencedColumnName = "id_discipline")
  public Discipline getDiscipline() {
    return discipline;
  }

  public void setDiscipline(Discipline disciplineByIdDiscipline) {
    this.discipline = disciplineByIdDiscipline;
  }
}
