package um.fds.agl.ter23.entities;

import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe {

  private @Id @GeneratedValue Long id;
  private String title;

  @ManyToMany
  private Iterable<Student> students;

  public Groupe() {
  }

  public Groupe(String title) {
    this.title = title;
    this.students = new HashSet<Student>();
  }

  public Groupe(String title, Iterable<Student> students) {
    this.title = title;
    this.students = students;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Iterable<Student> getStudents() {
    return students;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Groupe))
      return false;

    Groupe groupe = (Groupe) o;

    if (title != groupe.getTitle()) {
      return false;
    }

    Iterator<Student> gSetIt = groupe.getStudents().iterator();
    Iterator<Student> interSetIt = students.iterator();

    while (gSetIt.hasNext()) {
      if (!interSetIt.hasNext())
        return false;

      if (!(gSetIt.next().equals(interSetIt.next()))) {
        return false;
      }
    }

    return true;

  }

  @Override
  public int hashCode() {
    int result = getId().hashCode();
    result = 31 * result + getTitle().hashCode();
    result = 31 * result + getStudents().hashCode();

    return result;
  }

}
