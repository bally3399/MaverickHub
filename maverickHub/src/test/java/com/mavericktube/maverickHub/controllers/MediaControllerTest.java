package com.mavericktube.maverickHub.controllers;

import com.mavericktube.maverickHub.dto.request.UploadMediaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.mavericktube.maverickHub.utils.TestUtils.TEST_VIDEO_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"/db/data.sql"})
public class MediaControllerTest {
    @Autowired
    private MockMvc mockMvc;
  @Test
  public void testMediaController() throws Exception {
      try(InputStream inputStream = Files.newInputStream(Paths.get(TEST_VIDEO_LOCATION))){
          MultipartFile file = new MockMultipartFile("mediaFile", inputStream);
          mockMvc.perform(multipart("/api/v1/media")
                          .file(file.getName(), file.getBytes())
                          .part(new MockPart("userId", "200".getBytes()))
                          .part(new MockPart("description", "test description".getBytes()))
                          .part(new MockPart("category", "ACTION".getBytes()))
                  .contentType(MediaType.MULTIPART_FORM_DATA))
                  .andExpect(status().isCreated())
                  .andDo(print());
      }catch (Exception exception) {
            throw exception;
      }
  }

  @Test
    public void tesGetMediaForUser(){
      try {
          mockMvc.perform(get("/api/v1/media?userId=200")
                          .contentType(MediaType.APPLICATION_JSON))
                          .andExpect(status().is2xxSuccessful())
                          .andDo(print());
      }catch (Exception exception) {
          assertThat(exception).isNull();
      }
  }
}
