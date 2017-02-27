package com.practica.phase2.model;

import java.io.Serializable;

/**
 * Created by student on 2/27/2017.
 */
public class AverageMarkId implements Serializable {

  private int studentId;
  private String title;

  public AverageMarkId() {

  }

  public AverageMarkId(String title, int studentId) {
    this.title = title;
    this.studentId = studentId;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((title == null) ? 0 : title.hashCode());
    result = prime * result + studentId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AverageMarkId other = (AverageMarkId) obj;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (studentId != other.studentId)
      return false;
    return true;
  }
}
