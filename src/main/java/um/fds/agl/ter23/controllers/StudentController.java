package um.fds.agl.ter23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import um.fds.agl.ter23.entities.Student;
import um.fds.agl.ter23.forms.StudentForm;
import um.fds.agl.ter23.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/listStudents")
    public Iterable<Student> getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return studentService.getStudents();
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping(value = { "/addStudent" })
    public String showAddPersonPage(Model model) {

        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);

        return "addStudent";
    }

    @PostMapping(value = { "/addStudent" })
    public String addStudent(Model model, @ModelAttribute("StudentForm") StudentForm studentForm) {
        Student student = studentService.getStudent(studentForm.getId());
        if (student != null) {
            student.setFirstName(studentForm.getFirstName());
            student.setLastName(studentForm.getLastName());
        } else {
            student = new Student(studentForm.getFirstName(), studentForm.getLastName());
        }
        studentService.saveStudent(student);
        return "redirect:/listStudents";

    }

    @GetMapping(value = { "/showStudentUpdateForm/{id}" })
    public String showStudentUpdateForm(Model model, @PathVariable(value = "id") long id) {

        Student s = studentService.getStudent(id);
        if (s == null) {
            return "redirect:/addStudent";
        }
        StudentForm studentForm = new StudentForm(id, s.getFirstName(), s.getLastName());
        model.addAttribute("studentForm", studentForm);
        return "updateStudent";
    }

    @GetMapping(value = { "/deleteStudent/{id}" })
    public String deleteStudent(Model model, @PathVariable(value = "id") long id) {
        studentService.deleteStudent(id);
        return "redirect:/listStudents";
    }
}
