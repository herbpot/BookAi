package io.github.herbpot.bookai;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class JournalControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("저널이 생성 되는지 확인 하는 테스트")
    void createJournal() throws Exception {
        Map<String, Object> journal = new HashMap<>();
        journal.put("title","test");
        journal.put("author","test");
        journal.put("content","test");
        journal.put("bookId","0");
        mockMvc.perform(
                post("/write")
                        .contentType("multipart/form-data")
                        .content(objectMapper.writeValueAsString(journal))
                )
                .andExpect(status().is3xxRedirection());

    }

}
