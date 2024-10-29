package todolist.user.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import todolist.user.dto.JoinUserDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class UserApiTest {
    
    private static final Logger log = LoggerFactory.getLogger(UserApiTest.class);
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testJoinUser() throws Exception 
    {
        log.info("Hellow~");
        // 회원가입 요청 JSON 데이터 생성
        String joinUserRequest = objectMapper.writeValueAsString(new JoinUserDto("test1238",
         "test1238", "테스트 주소", "테스트 상세주소", 
         "970217", "01080842739", 'M'));

        mockMvc.perform(post("/api/join")    // 실제 회원가입 API 경로
                .contentType(MediaType.APPLICATION_JSON)
                .content(joinUserRequest))
                .andExpect(status().isOk());
        log.info("Bye~");
    }
}
