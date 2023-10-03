package um.fds.agl.ter23;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import um.fds.agl.ter23.entities.*;
import um.fds.agl.ter23.repositories.*;

@Component
public class DatabaseLoader implements CommandLineRunner {
        private final TeacherRepository teachers;
        private final TERManagerRepository managers;

        private final StudentRepository students;
        private final SubjectRepositories subject;
        private final GroupeRepository groupe;

        public DatabaseLoader(TeacherRepository teachers, TERManagerRepository managers, StudentRepository students,
                        SubjectRepositories subject, GroupeRepository groupe) {
                this.teachers = teachers;
                this.managers = managers;
                this.students = students;
                this.subject = subject;
                this.groupe = groupe;
        }

        @Override
        public void run(String... strings) throws Exception {
                TERManager terM1Manager = this.managers.save(new TERManager("Le", "Chef", "mdp", "ROLE_MANAGER"));
                SecurityContextHolder.getContext().setAuthentication(
                                new UsernamePasswordAuthenticationToken("Chef", "bigre",
                                                AuthorityUtils.createAuthorityList("ROLE_MANAGER"))); // the actual
                                                                                                      // password is not
                                                                                                      // needed here
                Teacher t1 = new Teacher("Ada", "Lovelace", "lovelace", terM1Manager, "ROLE_TEACHER");
                Teacher t2 = new Teacher("Alan", "Turing", "turing", terM1Manager, "ROLE_TEACHER");
                Student s1 = new Student("Gustave", "Flaubert");
                Student s2 = new Student("Frédéric", "Chopin");
                this.teachers.save(t1);
                this.teachers.save(t2);
                this.teachers.save(new Teacher("Leslie", "Lamport", "lamport", terM1Manager, "ROLE_TEACHER"));
                this.students.save(s1);
                this.students.save(s2);
                this.subject.save(new SubjectTER("TER", t1));
                this.subject.save(new SubjectTER("GL", t2));

                Set<Student> students = new HashSet<Student>();
                students.add(s1);
                students.add(s2);
                this.groupe.save(new Groupe("test", students));
                this.groupe.save(new Groupe("test2"));

                SecurityContextHolder.clearContext();

        }
}
