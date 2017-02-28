package com.practica.phase2.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by student on 2/22/2017.
 */
@Entity
public class Address {
  private Integer idAddress;
  @NotNull(message = "*Write country")
  private String country;
  @NotEmpty(message = "*Write city")
  private String city;
  @NotEmpty(message = "*Write address")
  private String address;
  private Collection<Person> person;

  @Id
  @GeneratedValue
  @Column(name = "id_address", nullable = false, insertable = false, updatable = false)
  public Integer getIdAddress() {
    return idAddress;
  }

  public void setIdAddress(Integer idAddress) {
    this.idAddress = idAddress;
  }

  @Basic
  @Column(name = "country", nullable = true, length = -1)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Basic
  @Column(name = "city", nullable = true, length = -1)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Basic
  @Column(name = "address", nullable = true, length = -1)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @OneToMany(mappedBy = "address")
  public Collection<Person> getPerson() {
    return person;
  }

  public void setPerson(Collection<Person> person) {
    this.person = person;
  }
}
