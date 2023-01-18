package com.example.iti0302backend.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ImageTest extends AbstractIntegrationTes {

    @Autowired
    private MockMvc mvc;

    @Test
    void saveImage() throws Exception {
//        FileInputStream file = new FileInputStream("src/main/test/com/example/iti0302backend/testAssets/test_image.jpg");
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test_image.jpg",
                String.valueOf(MediaType.MULTIPART_FORM_DATA), "test_image.jpg".getBytes());


        mvc.perform(multipart("/api/public/images").file(multipartFile).with(user("user"))
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept("application/json"))
                        .andExpect(status().isOk());

        mvc.perform(get("/api/public/images/0")).andExpect(status().isOk());
    }

}
