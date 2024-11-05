package todolist.user.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;

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
    @Transactional
    public void testJoinUser() throws Exception 
    {
        log.info("Hellow~");
        // 회원가입 요청 JSON 데이터 생성
        String joinUserRequest = objectMapper.writeValueAsString(new JoinUserDto("test1238",
         "test1238", "테스트 주소", "테스트 상세주소", 
         "970217", "01080842739", 'M'));

        ResultActions resultactions = mockMvc.perform(post("/api/join")    // 실제 회원가입 API 경로
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(joinUserRequest));
                                            
        log.info("return json : " + resultactions.andReturn().getResponse().getContentAsString());
        resultactions.andExpect(status().isOk());
        log.info("Bye~");
    }

    @Test
    @Transactional
    public void testLoginUser() throws Exception
    {
        log.info("[testLoginUser Start]");
        String id = "test123";
        String password = "test1238";
        String loginUserRequest = objectMapper.writeValueAsString(new LoginUserDto(id, password));

        ResultActions resultActions = mockMvc.perform(post("/api/login")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(loginUserRequest))
                                            .andExpect(status().isOk());
        String returnJson = resultActions.andReturn().getResponse().getContentAsString();
        log.info("return json : " + returnJson);
        log.info("[testLoginUser End]");
    }
}
