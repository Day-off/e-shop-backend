package com.example.iti0302backend.integrationTests;

import com.example.iti0302backend.repository.UserRepository;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostTests extends AbstractIntegrationTes {

    @Autowired
    private MockMvc mvc;

    @Test
    void getPost() throws Exception {
        mvc.perform(get("/api/findById?id=0").with(user("user")))
                .andExpect(jsonPath("$.head").value("Sample"))
                .andExpect(jsonPath("$.description").value("sample"))
                .andExpect(status().isOk());
    }

    @Test
    void getPosts() throws Exception {
        mvc.perform(get("/api/posts").with(user("user")))
                .andExpect(jsonPath("$.[0].head").isNotEmpty())
                .andExpect(status().isOk());
    }

    @Test
    void addPost() throws Exception {
        JSONObject postData = new JSONObject();
        postData.put("head", "Sample3");
        postData.put("description", "sample3");
        postData.put("userId", "0");
        postData.put("categoryId", "1");

        mvc.perform(post("/api/posts").with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postData.toJSONString()))
                .andExpect(status().isOk());

        mvc.perform(get("/api/findById?id=1").with(user("user")))
                .andExpect(jsonPath("$.head").value("Sample3"))
                .andExpect(jsonPath("$.description").value("sample3"))
                .andExpect(status().isOk());
    }

    @Test
    void getSortedBuy() throws Exception {
        mvc.perform(get("/api/public/?page=0&orderBy=id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].head").value("Sample3"));
    }

    @Test
    void search() throws Exception {
        mvc.perform(get("/api/public?page=0&orderBy=id&header=Find"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].head").value("Find"));
    }

    @Test
    void deletePost() throws Exception {
        JSONObject postData = new JSONObject();
        postData.put("id", "2");


        mvc.perform(post("/api/posts/delete").with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postData.toJSONString()))
                .andExpect(status().isOk());

        mvc.perform(get("/api/findById?id=2").with(user("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.head").doesNotExist());
    }


    @Test
    void updatePost() throws Exception {
        mvc.perform(get("/api/posts/update?id=4&header=Update").with(user("user")))
                .andExpect(status().isOk());

        mvc.perform(get("/api/findById?id=4").with(user("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.head").value("Update"));

    }

    @Test
    void createOrder() throws Exception {
        mvc.perform(get("/api/posts/buy?postId=0&userId=0&imageId=0").with(user("user")))
                .andExpect(status().isOk());

    }
    @Test
    void deleteOrder() throws Exception {
        mvc.perform(delete("/api/posts/deleteOrder?orderId=2").with(user("user")))
                .andExpect(status().isOk());

    }

    @Test
    void getUserOrders() throws Exception {
        mvc.perform(get("/api/public/mypost?page=0&orderBy=id&userId=0").with(user("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].userId").value(0));
    }
}
