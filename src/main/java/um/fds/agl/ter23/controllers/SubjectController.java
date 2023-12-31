package um.fds.agl.ter23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    if (teacherService.getTeacher(subjectForm.getTeacherId()).isEmpty()) {
      System.out.println("\u001B[31m [log:error]Teacher not found for id  \u001B[0m");
      System.out.println(subjectForm.getTeacherId());
      return "redirect:/addSubject";
    }

    SubjectTER subject = new SubjectTER(subjectForm.getTitle(),
        teacherService.getTeacher(subjectForm.getTeacherId()).get());
    sujetTERServices.saveSubject(subject);
    return "redirect:/listSubject";
  }

  @GetMapping(value = { "/updateSubject/{id}" })
  public String updateSubjectPage(Model model, @PathVariable(value = "id") String id) {

    SubjectForm subject = new SubjectForm();
    model.addAttribute("subjectForm", subject);
    model.addAttribute("subjectData",
        sujetTERServices.getSubject(Long.parseLong(id)));
    model.addAttribute("teachers", teacherService.getTeachers());
    return "updateSubject";
  }

  @PostMapping(value = { "/updateSubject" })
  public String updateSubject(Model model, @ModelAttribute("SubjectForm") SubjectForm subjectForm) {
    if (true) {
      System.out.println("\u001B[31m [log:proof] load  \u001B[0m");
    }
    SubjectTER subject = sujetTERServices.getSubject(subjectForm.getId());
    subject.setTitle(subjectForm.getTitle());
    subject.setTeacher(teacherService.getTeacher(subjectForm.getTeacherId()).get());
    sujetTERServices.saveSubject(subject);
    return "redirect:/listSubject";
  }

  @GetMapping(value = { "/deleteSubject/{id}" })
  public String deleteSubject(Model model, @PathVariable(value = "id") String id) {
    sujetTERServices.deleteSubject(Long.parseLong(id));
    return "redirect:/listSubject";
  }

}
