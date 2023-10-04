package um.fds.agl.ter23.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import um.fds.agl.ter23.entities.Groupe;
import um.fds.agl.ter23.entities.Student;
import um.fds.agl.ter23.forms.GroupeForm;
import um.fds.agl.ter23.services.GroupeService;
import um.fds.agl.ter23.services.StudentService;

@Controller
public class GroupeControle {

  @Autowired
  GroupeService groupeService;

  @Autowired
  StudentService studentService;

  @RequestMapping(value = "/listGroupe")
  public String groupeListPage(Model model) {

    Iterable<Groupe> groupes = groupeService.getAllGroupe();

    model.addAttribute("Groupes", groupes);

    return "listGroupe";
  }

  @GetMapping(value = "/addGroupe")
  public String addGroupePage(Model model) {

    GroupeForm form = new GroupeForm();

    model.addAttribute("groupeFrom", form);
    model.addAttribute("studentsList", studentService.getStudents());

    return "addGroupe";
  }

  @PostMapping(value = "/addGroupe")
  public String addGroupe(Model model, @ModelAttribute("GroupeForm") GroupeForm groupeForm) {

    System.out.println("\u001B[31m [log:error]\u001B[0m");
    System.out.println(
        groupeForm.getTitle());
    Set<Student> students = groupeForm.getStudents();

    for (Student s : students) {
      System.out.println(s.getLastName());
    }

    groupeService.save(new Groupe(groupeForm.getTitle(), students));

    return "redirect:listGroupe";
  }

  @RequestMapping(value = "/updateGroupe/{id}")
  public String updateGroupePage(Model model) {

    return "updateGroupe";
  }

}
