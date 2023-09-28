package um.fds.agl.ter23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.fds.agl.ter23.entities.Student;
import um.fds.agl.ter23.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Get a student by id
     * If the student does not exist, return null
     * 
     * @param id
     * @return Student
     */
    public Student getStudent(final Long id) {

        if (!studentRepository.existsById(id)) {
            return null;
        }
        return studentRepository.findById(id).get();
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(final Long id) {
        studentRepository.deleteById(id);
    }

    public Student saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

}