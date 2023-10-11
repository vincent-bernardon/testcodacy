package um.fds.agl.ter23.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import um.fds.agl.ter23.services.TeacherService;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TeacherControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private TeacherService teacherService;
    @Test
    @WithMockUser(username = "Chef", roles = "MANAGER")
    void addTeacherGet() throws Exception {
        MvcResult result = mvc.perform(get("/addTeacher"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("addTeacher"))
                .andReturn();
    }

    @Test
    @WithMockUser(username = "Chef", roles = "MANAGER")
    void addTeacherGetAsummingThat(){
        assumingThat(teacherService.getTeacher(10l) == null,()-> {
            MvcResult result = mvc.perform(post("/addTeacher")
                            .param("firstName", "Anne-Marie")
                            .param("lastName", "Kermarrec")
                            .param("id", "10")
                    )
                    .andExpect(status().is3xxRedirection())
                    .andReturn();
            // il faut ici vérifier que le nouvel enseignant a bien été ajouté
        });
    }

    @Test
    @WithMockUser(username = "Chef", roles = "MANAGER")
    void addTeacherPostExistingTeacher(){
        assumingThat(teacherService.getTeacher(10l) != null,()->{
            MvcResult result = mvc.perform(post("/addTeacher")
                            .param("firstName", "Anne-Marie")
                            .param("lastName", "Kermarrec")
                            .param("id", "10")
                    )
                    .andExpect(status().is3xxRedirection())
                    .andReturn();
            result = mvc.perform(post("/addTeacher")
                    .param("firstName", "Marie")
                    .param("lastName", "Kurry")
                    .param("id", "10")
            )
            .andExpect(status().is3xxRedirection())
            .andReturn();
            // il faut vérifier que l'enseignant a bien été modifié
            assertTrue(teacherService.getTeacher(10l).getFirstName().equals("Marie"));
        });
    }

    @Test
    @WithMockUser(username = "Chef", roles = "MANAGER")
    void addTeacherPostExistingTeacher2() throws Exception {

        MvcResult result = mvc.perform(post("/addTeacher")
                        .param("firstName", "Anne-Marie")
                        .param("lastName", "Kermarrec")
                        .param("id", "10")
                )
                .andExpect(status().is3xxRedirection())
                .andReturn();

        MvcResult result2 = mvc.perform(post("/addTeacher")
                        .param("firstName", "Anne-Marie2")
                        .param("lastName", "Kermarrec2")
                        .param("id", "10")
                )
                .andExpect(status().is3xxRedirection())
                .andReturn();
        System.out.println(result2);
        assertEquals("Kermarrec2",teacherService.getTeacher(10L).getLastName() );

        // il faut ici vérifier que le nouvel enseignant a bien été ajouté
    }

}