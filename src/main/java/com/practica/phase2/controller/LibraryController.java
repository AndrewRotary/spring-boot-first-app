package com.practica.phase2.controller;

import com.practica.phase2.dao.LibrarySubscriptionRepository;
import com.practica.phase2.dao.StudentRepository;
import com.practica.phase2.model.LibrarySubscription;
import com.practica.phase2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by student on 2/24/2017.
 */
@Controller
public class LibraryController {

  @Autowired
  LibrarySubscriptionRepository librarySubscriptionRepository;

  @Autowired
  private StudentRepository studentRepository;

  @RequestMapping("/editLib/{id}")
  public String editLib(Model model, @PathVariable Integer id) {
    LibrarySubscription librarySubscription = librarySubscriptionRepository.findOne(id);
    Student student = studentRepository.findStudentByLibrarySubscription(librarySubscription);

    model.addAttribute("lib", librarySubscription);
    model.addAttribute("st", student);
    return "editLibStatus";
  }

  @RequestMapping(value = "/editLib", method = RequestMethod.POST)
  public String saveLib(@ModelAttribute("lib") LibrarySubscription librarySubscription, HttpServletRequest request,
                        HttpServletResponse response, Model model) {
    librarySubscriptionRepository.save(librarySubscription);
    return "redirect:/";
  }

}
