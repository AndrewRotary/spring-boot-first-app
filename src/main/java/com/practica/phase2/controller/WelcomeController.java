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
    List<Student> students = (List<Student>) studentRepository.findAll();

    model.addAttribute("students", students);
    return "hello";
  }

  @RequestMapping("/addStudent")
  public String addStudetn(Model model){
    List<PhoneType> phoneTypes = (List<PhoneType>) phoneTypeRepository.findAll();
    List<Groupp> groups = (List<Groupp>) grouppRepository.findAll();
    Student student = new Student();
    student.getPhones().add(new Phone());
    model.addAttribute("groups", groups);
    model.addAttribute("phoneTypes", phoneTypes);
    model.addAttribute("student", student);
    return "addStudent";
  }

  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
  public String saveStudent(@Valid @ModelAttribute("student") Student student, HttpServletRequest request,
                            HttpServletResponse response, Model model){
    LibrarySubscription librarySubscription = new LibrarySubscription();
    librarySubscription.setStatus("NONE");
    student.setLibrarySubscription(librarySubscription);
    studentRepository.save(student);
    MultipartFile image = student.getImageMultipart();
    String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    path = Paths.get("C:/Users/student/IdeaProjects/student/src/main/resources/static/images" + student.getId() +".jpg");
    if (image != null && !image.isEmpty()) {
      try {
        image.transferTo(new File(path.toString()));
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Product image saving failed.", e);
      }
    }
    for(Phone phone : student.getPhones()){
      phone.setPerson(student);
      phoneRepository.save(phone);
    }
    return "redirect:/";
  }


}
