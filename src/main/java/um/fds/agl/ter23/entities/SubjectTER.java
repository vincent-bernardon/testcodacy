package um.fds.agl.ter23.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubjectTER {

  private @Id @GeneratedValue Long id;
  private String title;

  private @ManyToOne Teacher teacher;

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

  public SubjectTER() {
  }

  public SubjectTER(String title, Teacher teacher) {
    this.title = title;
    this.teacher = teacher;
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

    return getTeacher().equals(sujet.getTeacher());

  }

  @Override
  public int hashCode() {
    int result = getId().hashCode();
    result = 31 * result + getTitle().hashCode();
    result = 31 * result + getTeacher().hashCode();

    return result;
  }

}
