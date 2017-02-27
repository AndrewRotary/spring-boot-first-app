package com.practica.phase2.dao;

import com.practica.phase2.model.LibrarySubscription;
import com.practica.phase2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by student on 2/21/2017.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
  public Student findStudentByLibrarySubscription(LibrarySubscription librarySubscription);
  public List<Student> findStudentByStatus(Boolean status);
  }
