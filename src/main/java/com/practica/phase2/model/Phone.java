package com.practica.phase2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by student on 2/22/2017.
 */
@Entity
public class Phone {
  private Integer idPhone;
  @NotNull(message = "*write phone number")
  private Integer number;
  private String phoneType;
  private Person person;

  @Id
  @GeneratedValue
  @Column(name = "id_phone", nullable = false, insertable = false, updatable = false)
  public Integer getIdPhone() {
    return idPhone;
  }

  public void setIdPhone(Integer idPhone) {
    this.idPhone = idPhone;
  }

  @Basic
  @Column(name = "number", nullable = true)
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Basic
  @Column(name = "phone_type", nullable = true, length = 10)
  public String getPhoneType() {
    return phoneType;
  }

  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  @ManyToOne
  @JoinColumn(name = "id_person", referencedColumnName = "id")
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person personByIdPerson) {
    this.person = personByIdPerson;
  }
}
