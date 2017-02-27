package com.practica.phase2.model;

import javax.persistence.*;

/**
 * Created by student on 2/27/2017.
 */
@Entity
@Table(name = "average_mark", schema = "public", catalog = "practica")
@IdClass(AverageMarkId.class)
public class AverageMark {
  private Integer studentId;
  private String title;
  private Double avg;

  @Id
//  @Basic
  @Column(name = "student_id", nullable = true)
  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  @Id
//  @Basic
  @Column(name = "title", nullable = true, length = -1)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Basic
  @Column(name = "avg", nullable = true, precision = 0)
  public Double getAvg() {
    return avg;
  }

  public void setAvg(Double avg) {
    this.avg = avg;
  }

}
