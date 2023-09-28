package um.fds.agl.ter23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.fds.agl.ter23.entities.Groupe;
import um.fds.agl.ter23.repositories.GroupeRepository;

@Service
public class GroupeService {

  @Autowired
  GroupeRepository groupeRepository;

  public Groupe getGroupeById(long id) {

    if (groupeRepository.existsById(id)) {
      return groupeRepository.findById(id).get();
    }

    return null;
  }

  public Iterable<Groupe> getAllGroupe() {
    return groupeRepository.findAll();
  }

  public void save(Groupe groupe) {
    groupeRepository.save(groupe);
  }

}
