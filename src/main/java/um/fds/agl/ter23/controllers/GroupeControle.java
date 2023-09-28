package um.fds.agl.ter23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupeControle {

  @RequestMapping(value = "/listGroupe")
  public String groupeListPage() {
    return "listGroupe";
  }

}
