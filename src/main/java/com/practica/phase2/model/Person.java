package com.practica.phase2.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by student on 2/22/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {

  private Integer id;
  @NotNull
  @Size(min=2, max=30, message = "*First Name size must be between 2 and 30")
  private String firstName;
  @NotNull(message = "*choose gender")
  private String gender;
  private String picturePath;
  @NotNull
  @Size(min=2, max=30, message = "*Last Name size must be between 2 and 30")
  private String lastName;
  @NotNull(message = "*choose date of birth")
  @Past
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date dob;
  @Valid
  private Address address;
  private LibrarySubscription librarySubscription;
  @Valid
  private Collection<Phone> phones;
  @Transient
  private MultipartFile imageMultipart;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer idPerson) {
    this.id = idPerson;
  }

  @Basic
  @Column(name = "first_name", nullable = true, length = 100)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "gender", nullable = true, length = 10)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "picture_path", nullable = true, length = 250)
  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  @Basic
  @Column(name = "last_name", nullable = true, length = 100)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "dob", nullable = true)
  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_address", referencedColumnName = "id_address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_library_subscription", referencedColumnName = "id_library_subscription")
  public LibrarySubscription getLibrarySubscription() {
    return librarySubscription;
  }

  public void setLibrarySubscription(LibrarySubscription librarySubscriptionByIdLibrarySubscription) {
    this.librarySubscription = librarySubscriptionByIdLibrarySubscription;
  }

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  public Collection<Phone> getPhones() {
    if (phones == null) {
      phones = new ArrayList<Phone>();
    }
    return phones;
  }

  public void setPhones(Collection<Phone> phonesByIdPerson) {
    this.phones = phonesByIdPerson;
  }

  @Transient
  public MultipartFile getImageMultipart() {
    return imageMultipart;
  }

  @Transient
  public void setImageMultipart(MultipartFile imageMultipart) {
    this.imageMultipart = imageMultipart;
  }
}
