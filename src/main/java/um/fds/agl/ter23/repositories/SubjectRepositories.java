package um.fds.agl.ter23.repositories;

import org.springframework.data.repository.CrudRepository;

import um.fds.agl.ter23.entities.SubjectTER;

public interface SubjectRepositories extends CrudRepository<SubjectTER, Long> {

  @Override
  SubjectTER save(SubjectTER subject);

}
