package um.fds.agl.ter23.repositories;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.AccessDeniedException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;


import um.fds.agl.ter23.entities.TERManager;
import um.fds.agl.ter23.entities.Teacher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teachers;
    @Autowired
    private TERManagerRepository managers;

    @BeforeEach
    public void setup() {

    }

    @Test
    void savingTeachersIsPossibleForManager() {
        SecurityContextHolder.getContext().setAuthentication((Authentication) new UsernamePasswordAuthenticationToken("lechef", "peuimporte", AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
        TERManager terM1Manager = new TERManager("Mathieu", "lechef","mdp", "ROLE_MANAGER");
        this.managers.save(terM1Manager);
        this.teachers.save(new Teacher("Margaret", "Hamilton", "margaret",
        terM1Manager, "ROLE_TEACHER"));
        assertThat(teachers.findByLastName("Hamilton"),
        is(notNullValue()));
    }

    @Test
    void savingTeachersIsPossibleForManager2() {
        
        assertThrows(AccessDeniedException.class,() ->{

        SecurityContextHolder.getContext().setAuthentication((Authentication) new UsernamePasswordAuthenticationToken("lechef", "peuimporte", AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
        TERManager terM1Manager = new TERManager("Mathieu", "lechef","mdp", "ROLE_TEACHER");
        this.managers.save(terM1Manager);
        this.teachers.save(new Teacher("Margaret", "Hamilton", "margaret",
        terM1Manager, "ROLE_TEACHER"));
        });

    }

    

}
