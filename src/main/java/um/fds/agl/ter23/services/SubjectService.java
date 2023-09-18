package um.fds.agl.ter23.services;

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
}
