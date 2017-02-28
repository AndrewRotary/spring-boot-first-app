package com.practica.phase2.controller;

import com.practica.phase2.dao.*;
import com.practica.phase2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by student on 2/27/2017.
 */
@Controller
public class StudentController {


  @Autowired
  PhoneTypeRepository phoneTypeRepository;
  @Autowired
  PhoneRepository phoneRepository;
  @Autowired
  ServletContext context;
  @Autowired
  LibrarySubscriptionRepository librarySubscriptionRepository;
  @Autowired
  private GrouppRepository grouppRepository;
  private Path path;
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/addStudent")
  public String addStudetn(Model model) {
    List<PhoneType> phoneTypes = (List<PhoneType>) phoneTypeRepository.findAll();
    List<Groupp> groups = (List<Groupp>) grouppRepository.findAll();
    Student student = new Student();
    student.getPhones().add(new Phone());
    model.addAttribute("groups", groups);
    model.addAttribute("phoneTypes", phoneTypes);
    model.addAttribute("student", student);
    return "addStudent";
  }

  @PostMapping(value = "/addStudent")
  public String saveStudent(@ModelAttribute("student") @Valid Student student,BindingResult bindingResult, HttpServletRequest request) {

    if (bindingResult.hasErrors()) {
      return "addStudent";
    }
    LibrarySubscription librarySubscription = new LibrarySubscription();
    librarySubscription.setStatus("NONE");
    student.setLibrarySubscription(librarySubscription);

    MultipartFile image = student.getImageMultipart();
    String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    path = Paths.get("C:/Users/student/IdeaProjects/student/src/main/resources/static/images/" + student.getId() + ".jpg");
    if (image != null && !image.isEmpty()) {
      try {
        image.transferTo(new File(path.toString()));
      } catch (Exception e) {
        student.setPicturePath("std.jpg");
      }
    }
    student.setPicturePath(student.getId() + ".jpg");
    student.setStatus(true);
    studentRepository.save(student);
    for (Phone phone : student.getPhones()) {
      phone.setPerson(student);
      phoneRepository.save(phone);
    }
    return "redirect:/";
  }

  @RequestMapping("/editStudent/{id}")
  public String editStudent(Model model, @PathVariable Integer id) {
    Student student = studentRepository.findOne(id);
    List<PhoneType> phoneTypes = (List<PhoneType>) phoneTypeRepository.findAll();
    List<Groupp> groups = (List<Groupp>) grouppRepository.findAll();
    model.addAttribute("student", student);
    model.addAttribute("groups", groups);
    model.addAttribute("phoneTypes", phoneTypes);

    return "addStudent";
  }

  @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
  public String editStudentPost(@Valid @ModelAttribute("student") Student student, HttpServletRequest request,
                                HttpServletResponse response, Model model) {

    LibrarySubscription librarySubscription = librarySubscriptionRepository.findOne(student.getLibrarySubscription().getIdLibrarySubscription());
    student.setLibrarySubscription(librarySubscription);
    Student student1 = student;
    MultipartFile image = student.getImageMultipart();
    String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    path = Paths.get("C:/Users/student/IdeaProjects/student/src/main/resources/static/images/" + student.getId() + ".jpg");
    if (image != null && !image.isEmpty()) {
      try {
        image.transferTo(new File(path.toString()));
        student.setPicturePath(student.getId() + ".jpg");
      } catch (Exception e) {
        student.setPicturePath("std.jpg");
      }
    } else {
      student.setPicturePath("std.jpg");
    }
    student.setStatus(true);
    studentRepository.save(student);
    for (Phone phone : student.getPhones()) {
      phone.setPerson(student);
      phoneRepository.save(phone);
    }
    return "redirect:/";
  }

  @RequestMapping("deleteStudents")
  public String deleteStudents(HttpServletRequest request) {
    String[] idStudents = request.getParameterMap().get("delete[]");
    for (int i = 0; i < idStudents.length; i++) {
      Student student = studentRepository.findOne(Integer.valueOf(idStudents[i]));
      student.setStatus(false);
      studentRepository.save(student);
    }

    return "redirect:/";
  }

}
