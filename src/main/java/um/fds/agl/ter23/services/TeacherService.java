package um.fds.agl.ter23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.fds.agl.ter23.entities.Teacher;
import um.fds.agl.ter23.repositories.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacher(final Long id) {
        if (!teacherRepository.existsById(id)) {
            System.out.println("\u001B[31m [log:error]Teacher not found for id  \u001B[0m");
            System.out.println(id);
            return null;
        }
        return teacherRepository.findById(id).get();
    }

    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(final Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher saveTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

}