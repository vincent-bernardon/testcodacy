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


import static org.junit.jupiter.api.Assertions.assertTrue;
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
    void addTeacherPostNonExistingTeacher() throws Exception {
        assertTrue(teacherService.getTeacher(10l) == null);
        MvcResult result = mvc.perform(post("/addTeacher")
                        .param("firstName", "Anne-Marie")
                        .param("lastName", "Kermarrec")
                        .param("id", "10")
                )
                .andExpect(status().is3xxRedirection())
                .andReturn();
        // il faut ici vérifier que le nouvel enseignant a bien été ajouté
    }
}