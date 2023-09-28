package um.fds.agl.ter23.services;

import org.springframework.stereotype.Service;

@Service
public class ErrorServices {

  public String renderErrorPath() {
    return "error";
  }

  public void LogError() {
    System.out.println("Error");
  }

  public String redirectToPathAndInform(String path, String message) {
    System.out.println(message);
    return "redirect:" + path;
  }
}
