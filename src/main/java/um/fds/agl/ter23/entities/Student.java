package um.fds.agl.ter23.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Student extends UserTER {

    @ManyToMany(mappedBy = "students")
    private Set<Groupe> groupes;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        String[] roles = { "ROLE_STUDENT" };
        this.setRoles(roles);
        this.groupes = new HashSet<Groupe>();
    }

    public Student(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
        String[] roles = { "ROLE_STUDENT" };
        this.setRoles(roles);
        this.groupes = new HashSet<Groupe>();
    }

    public Student(long id, String firstName, String lastName, Set<Groupe> groupes) {
        super(id, firstName, lastName);
        String[] roles = { "ROLE_STUDENT" };
        this.setRoles(roles);
        this.groupes = groupes;
    }

    public Student() {
    }

}
