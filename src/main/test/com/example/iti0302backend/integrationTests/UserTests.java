package com.example.iti0302backend.integrationTests;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class UserTests extends AbstractIntegrationTes {

    @Autowired
    private MockMvc mvc;

    @Test
    void getUsers() throws Exception {
        mvc.perform(get("/api/users").with(user("user")))
                .andExpect(jsonPath("$.[0].firstName").value("Test1"))
                .andExpect(status().isOk());
    }

    @Test
    void getUser() throws Exception {
        mvc.perform(get("/api/user?id=0").with(user("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Test1"))
                .andExpect(jsonPath("$.lastName").value("test"))
                .andExpect(jsonPath("$.email").value("test1@gmail.com"));
    }

    @Test
    void registerUser() throws Exception {
        JSONObject userJson = new JSONObject();
        userJson.put("firstName", "Test2");
        userJson.put("lastName", "Test");
        userJson.put("email", "test2@gmail.com");
        userJson.put("password", "123");
        userJson.put("id", "1");

        mvc.perform(post("/api/public/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson.toJSONString()))
                .andExpect(status().isOk());

        mvc.perform(get("/api/user?id=1").with(user("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Test2"));
    }

    @Test
    void loggedUser() throws Exception {
        JSONObject userRegisterJson = new JSONObject();
        userRegisterJson.put("firstName", "Test2");
        userRegisterJson.put("lastName", "Test");
        userRegisterJson.put("email", "test2@gmail.com");
        userRegisterJson.put("password", "123");
        userRegisterJson.put("id", "1");

        mvc.perform(post("/api/public/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRegisterJson.toJSONString()))
                .andExpect(status().isOk());

        JSONObject loginUserJson = new JSONObject();
        loginUserJson.put("email", "test2@gmail.com");
        loginUserJson.put("password", "123");


        mvc.perform(post("/api/public/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginUserJson.toJSONString()))
                .andExpect(status().isOk());
    }

    @Test
    void badLogin() throws Exception {
        JSONObject loginUserJson = new JSONObject();
        loginUserJson.put("email", "bad");
        loginUserJson.put("password", "bad");


        try {
            mvc.perform(post("/api/public/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(loginUserJson.toJSONString()));
        }catch (NestedServletException e){
            assertThat(e.getMessage()).contains("User not found");
        }

    }  @Test
    void wrongPasswordLogin() throws Exception {
        JSONObject loginUserJson = new JSONObject();
        loginUserJson.put("email", "test1@gmail.com");
        loginUserJson.put("password", "wrong");


        try {
            mvc.perform(post("/api/public/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(loginUserJson.toJSONString()));
        }catch (NestedServletException e){
            assertThat(e.getMessage()).contains("Invalid password !");
        }

    }
}
