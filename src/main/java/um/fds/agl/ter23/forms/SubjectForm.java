package um.fds.agl.ter23.forms;

public class SubjectForm {
  public String title;
  public long teacherId;
  public long id;

  public SubjectForm(String title, Long teacherId, Long id) {
    this.title = title;
    this.teacherId = teacherId;
    this.id = id;

  }

  public SubjectForm() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(long id) {
    this.teacherId = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
