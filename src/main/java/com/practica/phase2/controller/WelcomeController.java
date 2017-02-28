package com.practica.phase2.controller;

import com.practica.phase2.dao.*;
import com.practica.phase2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by student on 2/21/2017.
 */
@Controller
public class WelcomeController {

  @Autowired
  PhoneTypeRepository phoneTypeRepository;
  @Autowired
  PhoneRepository phoneRepository;
  @Autowired
  ServletContext context;
  @Autowired
  LibrarySubscriptionRepository librarySubscriptionRepository;
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private GrouppRepository grouppRepository;
  private Path path;

  @RequestMapping("/")
  public String index(Model model) {
    List<Student> students = (List<Student>) studentRepository.findStudentByStatus(true);

    model.addAttribute("students", students);
    return "hello";
  }

}
