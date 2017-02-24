package com.practica.phase2.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@Table(name = "library_subscription", schema = "public", catalog = "practica")
public class LibrarySubscription {
  private Integer idLibrarySubscription;
  private Date startDate;
  private Date endDate;
  private String status;
  private Collection<Person> person;

  @Id
  @GeneratedValue
  @Column(name = "id_library_subscription", nullable = false, insertable = false, updatable = false)
  public Integer getIdLibrarySubscription() {
    return idLibrarySubscription;
  }

  public void setIdLibrarySubscription(Integer idLibrarySubscription) {
    this.idLibrarySubscription = idLibrarySubscription;
  }

  @Basic
  @Column(name = "start_date", nullable = true)
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @Basic
  @Column(name = "end_date", nullable = true)
  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Basic
  @Column(name = "status", nullable = true, length = 50)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @OneToMany(mappedBy = "librarySubscription")
  public Collection<Person> getPerson() {
    return person;
  }

  public void setPerson(Collection<Person> peopleByIdLibrarySubscription) {
    this.person = peopleByIdLibrarySubscription;
  }
}
