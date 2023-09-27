package um.fds.agl.ter23.services;

import javax.swing.text.html.Option;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.fds.agl.ter23.entities.SubjectTER;
import um.fds.agl.ter23.repositories.SubjectRepositories;

@Service
public class SubjectService {

  @Autowired
  private SubjectRepositories subjectRepository;

  public Iterable<SubjectTER> getSubjectList() {

    Iterable<SubjectTER> subjectList;

    subjectList = subjectRepository.findAll();

    return subjectList;

  }

  public void saveSubject(SubjectTER subject) {
    subjectRepository.save(subject);
  }

  public int deleteSubject(long id) {
    if (!subjectRepository.existsById(id)) {
      System.out.println("\u001B[31m [log:error]Subject not found for id  \u001B[0m");
      System.out.println(id);
      return -1;
    }
    subjectRepository.deleteById(id);
    return 0;
  }

  public SubjectTER getSubject(long id) {
    if (!subjectRepository.existsById(id)) {
      System.out.println("\u001B[31m [log:error]Subject not found for id  \u001B[0m");
      System.out.println(id);
      return null;
    }
    return subjectRepository.findById(id).get();
  }

}
