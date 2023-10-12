package um.fds.agl.ter23.entities;

import javax.persistence.*;

@Entity
public class SubjectTER {

  private @Id @GeneratedValue Long id;
  private String title;

  private @ManyToOne Teacher teacher;
  private @ManyToOne Teacher teacherSec;

  public Long getId() {
    return id;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public String getTitle() {
    return title;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Teacher getTeacherSec() {
    return teacherSec;
  }

  public void setTeacherSec(Teacher teacherSec) {
    this.teacherSec = teacherSec;
  }

  public SubjectTER() {
  }

  public SubjectTER(String title, Teacher teacher) {
    this.title = title;
    this.teacher = teacher;

  }

  public SubjectTER(String title, Teacher teacher, Teacher teacherSec) {
    this.title = title;
    this.teacher = teacher;
    this.teacherSec = teacherSec;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof SubjectTER))
      return false;

    SubjectTER sujet = (SubjectTER) o;

    if (!getId().equals(sujet.getId()))
      return false;
    if (!getTitle().equals(sujet.getTitle()))
      return false;
    if(!getTeacherSec().equals(sujet.getTeacherSec()))
      return false;

    return getTeacher().equals(sujet.getTeacher());

  }

  @Override
  public int hashCode() {
    int result = getId().hashCode();
    result = 31 * result + getTitle().hashCode();
    result = 31 * result + getTeacher().hashCode();
    result = 31 * result + getTeacherSec().hashCode();


    return result;
  }

}
