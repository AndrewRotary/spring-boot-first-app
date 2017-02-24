package com.practica.phase2.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
public class Groupp {
  private Integer idGroup;
  private String name;
  private Collection<Student> student;

  @Id
  @Column(name = "id_group", nullable = false, insertable = false, updatable = false)
  public Integer getIdGroup() {
    return idGroup;
  }

  public void setIdGroup(Integer idGroup) {
    this.idGroup = idGroup;
  }

  @Basic
  @Column(name = "name", nullable = true, length = -1)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany(mappedBy = "group")
  public Collection<Student> getStudent() {
    return student;
  }

  public void setStudent(Collection<Student> studentsByIdGroup) {
    this.student = studentsByIdGroup;
  }
}
