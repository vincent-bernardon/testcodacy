package um.fds.agl.ter23.forms;

import java.util.Set;

import um.fds.agl.ter23.entities.Student;

public class GroupeForm {
  private long id;
  private String title;
  private Set<Student> students;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

}
