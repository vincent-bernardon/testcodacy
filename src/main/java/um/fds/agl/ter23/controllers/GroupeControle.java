package um.fds.agl.ter23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import um.fds.agl.ter23.entities.Groupe;
import um.fds.agl.ter23.services.GroupeService;

@Controller
public class GroupeControle {

  @Autowired
  GroupeService groupeService;

  @RequestMapping(value = "/listGroupe")
  public String groupeListPage(Model model) {

    Iterable<Groupe> groupes = groupeService.getAllGroupe();

    model.addAttribute("Groupes", groupes);

    return "listGroupe";
  }

}
