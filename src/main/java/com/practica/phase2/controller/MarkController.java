package com.practica.phase2.controller;

import com.practica.phase2.dao.DisciplineRepository;
import com.practica.phase2.dao.MarkRepository;
import com.practica.phase2.dao.ProfesorRepository;
import com.practica.phase2.dao.StudentRepository;
import com.practica.phase2.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by student on 2/27/2017.
 */
@Controller
public class MarkController {

  @Autowired
  ProfesorRepository profesorRepository;

  @Autowired
  DisciplineRepository disciplineRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  MarkRepository markRepository;

  @RequestMapping("/addMark/{id}")
  public String addMark(@PathVariable Integer id, Model model){
    Mark mark = new Mark();
    mark.setStudent( studentRepository.findOne(id));
    model.addAttribute("mark", mark);
    model.addAttribute("profesors", profesorRepository.findAll());
    model.addAttribute("disciplines", disciplineRepository.findAll());
    return "addMark";
  }

  @RequestMapping(value = "/addMark", method = RequestMethod.POST )
  public String addMarkPost(@Valid @ModelAttribute("mark") Mark mark, Model model){
   markRepository.save(mark);
    return "redirect:/";
  }
}
