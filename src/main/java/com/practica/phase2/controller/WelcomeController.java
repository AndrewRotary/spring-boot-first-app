package com.practica.phase2.controller;

import com.practica.phase2.dao.*;
import com.practica.phase2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.acl.Group;
import java.util.List;

/**
 * Created by student on 2/21/2017.
 */
@Controller
public class WelcomeController {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private GrouppRepository grouppRepository;

  @Autowired
  PhoneTypeRepository phoneTypeRepository;

  @Autowired
  PhoneRepository phoneRepository;

  private Path path;

  @Autowired
  ServletContext context;

  @Autowired
  LibrarySubscriptionRepository librarySubscriptionRepository;

  @RequestMapping("/")
  public String index(Model model) {
    List<Student> students = (List<Student>) studentRepository.findStudentByStatus(true);
    model.addAttribute("students", students);
    return "hello";
  }

}
