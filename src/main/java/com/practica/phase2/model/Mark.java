package com.practica.phase2.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by student on 2/22/2017.
 */
@Entity
public class Mark {
  private Integer idMark;
  private Double mark;
  private Date createdDate;
  private Student student;
  private Profesor profesor;
  private Discipline discipline;

  @Id
  @Column(name = "id_mark", nullable = false, insertable = false, updatable = false)
  public Integer getIdMark() {
    return idMark;
  }

  public void setIdMark(Integer idMark) {
    this.idMark = idMark;
  }

  @Basic
  @Column(name = "mark", nullable = true, precision = 0)
  public Double getMark() {
    return mark;
  }

  public void setMark(Double mark) {
    this.mark = mark;
  }

  @Basic
  @Column(name = "created_date", nullable = true)
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
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
  @JoinColumn(name = "id_professor", referencedColumnName = "id")
  public Profesor getProfesor() {
    return profesor;
  }

  public void setProfesor(Profesor profesorByIdProfessor) {
    this.profesor = profesorByIdProfessor;
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
