package um.fds.agl.ter23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import um.fds.agl.ter23.entities.SubjectTER;
import um.fds.agl.ter23.forms.SubjectForm;
import um.fds.agl.ter23.services.SubjectService;
import um.fds.agl.ter23.services.TeacherService;

@Controller
public class SubjectController {

  @Autowired
  private SubjectService sujetTERServices;

  @Autowired
  private TeacherService teacherService;

  @GetMapping("/listSubject") // support of the "/" route
  public Iterable<SubjectTER> listSubject(Model model) {
    model.addAttribute("subjects", sujetTERServices.getSubjectList());

    return sujetTERServices.getSubjectList();
  }

  @GetMapping(value = { "/addSubject" })
  public String showAddSubjectPage(Model model) {
    SubjectForm subject = new SubjectForm();
    model.addAttribute("subjectForm", subject);
    model.addAttribute("teachers", teacherService.getTeachers());
    return "addSubject";
  }

  @PostMapping(value = { "/addSubject" })
  public String addSubject(Model model, @ModelAttribute("SubjectForm") SubjectForm subjectForm) {

    if (teacherService.getTeacher(subjectForm.getId()).isEmpty()) {
      System.out.println("Teacher not found");
      return "redirect:/addSubject";
    }

    SubjectTER subject = new SubjectTER(subjectForm.getTitle(),
        teacherService.getTeacher(subjectForm.getId()).get());
    sujetTERServices.saveSubject(subject);
    return "redirect:/listSubject";
  }

}
