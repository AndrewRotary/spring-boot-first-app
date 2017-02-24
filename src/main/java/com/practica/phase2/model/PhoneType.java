package com.practica.phase2.model;

import javax.persistence.*;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@Table(name = "phone_type", schema = "public", catalog = "practica")
public class PhoneType {
  private Integer idPhoneType;
  private String name;

  @Id
  @Column(name = "id_phone_type", nullable = false, insertable = false, updatable = false)
  public Integer getIdPhoneType() {
    return idPhoneType;
  }

  public void setIdPhoneType(Integer idPhoneType) {
    this.idPhoneType = idPhoneType;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
