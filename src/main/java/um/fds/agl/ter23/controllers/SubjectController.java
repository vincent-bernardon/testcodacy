package um.fds.agl.ter23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import um.fds.agl.ter23.entities.SubjectTER;
import um.fds.agl.ter23.services.StudentService;
import um.fds.agl.ter23.services.SubjectService;

@Controller
public class SubjectController {

  @Autowired
  private SubjectService sujetTERServices;
  @Autowired
  private StudentService studentService;

  @GetMapping("/listSubject") // support of the "/" route
  public Iterable<SubjectTER> listSubject(Model model) {
    model.addAttribute("subjects", sujetTERServices.getSubjectList());
    System.out.println("sujetTERServices.getSubjectList() : " + sujetTERServices.getSubjectList());
    return sujetTERServices.getSubjectList();
  }
}
