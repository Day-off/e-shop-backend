package com.example.iti0302backend.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CategoryTests extends AbstractIntegrationTes {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllCategory() throws Exception {
        mvc.perform(get("/api/categories").with(user("user")))
                .andExpect(jsonPath("$.[0].name").value("Animals"))
                .andExpect(status().isOk());
    }

    @Test
    void getCategoryById() throws Exception {
        mvc.perform(get("/api/category?id=1").with(user("user")))
                .andExpect(jsonPath("$.posts.[0].head").value("PostWithCategory"))
                .andExpect(status().isOk());
    }
}
