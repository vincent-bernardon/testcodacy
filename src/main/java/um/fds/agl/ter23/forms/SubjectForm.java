package um.fds.agl.ter23.forms;

import um.fds.agl.ter23.entities.TERManager;
import um.fds.agl.ter23.entities.Teacher;

public class SubjectForm {
  public String title;
  public long teacherId;
  public long id;
  public Teacher teacherSec;

  public SubjectForm(String title, Long teacherId, Long id) {
    this.title = title;
    this.teacherId = teacherId;
    this.id = id;

  }

  public SubjectForm(String title, long teacherId, long id, Teacher teacherSec) {
    this.title = title;
    this.teacherId = teacherId;
    this.id = id;
    this.teacherSec = teacherSec;
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

  public Teacher getTeacherSec() {
    return teacherSec;
  }

  public void setTeacherSec(Teacher teacherSec) {
    this.teacherSec = teacherSec;
  }
}
