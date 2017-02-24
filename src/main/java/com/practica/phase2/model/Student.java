package com.practica.phase2.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@DiscriminatorValue("S")
public class Student extends Person {

  private Double calculateScholarship;
  private Boolean status;
  private String imageName;
  private Collection<DisciplineAverage> disciplineAverage;
  private Collection<Mark> marks;
  private Groupp group;

  @Basic
  @Column(name = "calculate_scholarship", nullable = true, precision = 0)
  public Double getCalculateScholarship() {
    return calculateScholarship;
  }

  public void setCalculateScholarship(Double calculateScholarship) {
    this.calculateScholarship = calculateScholarship;
  }


  @Basic
  @Column(name = "status", nullable = true)
  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Basic
  @Column(name = "image_name", nullable = true, length = -1)
  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  @OneToMany(mappedBy = "student")
  public Collection<DisciplineAverage> getDisciplineAverage() {
    return disciplineAverage;
  }

  public void setDisciplineAverage(Collection<DisciplineAverage> disciplineAveragesByIdStudent) {
    this.disciplineAverage = disciplineAveragesByIdStudent;
  }

  @OneToMany(mappedBy = "student")
  public Collection<Mark> getMarks() {
    return marks;
  }

  public void setMarks(Collection<Mark> marks) {
    this.marks = marks;
  }

  @ManyToOne
  @JoinColumn(name = "id_group", referencedColumnName = "id_group")
  public Groupp getGroup() {
    return group;
  }

  public void setGroup(Groupp group) {
    this.group = group;
  }
}
