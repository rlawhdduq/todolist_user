package todolist.user.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import todolist.user.dto.AuthUserDto;
import todolist.user.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserQueryTest {
    
    private static final Logger log = LoggerFactory.getLogger(UserQueryTest.class);

    @Autowired
    private UserRepository userRepository;
    // @Autowired
    // private ObjectMapper mapper;

    // @Test
    // @Transactional
    public void userLoginQueryTest() throws Exception 
    {
        String id = "test1238";
        String password = "test1238";

        AuthUserDto authUserDto = userRepository.findUserOne(id, password);

        // String returnJson = mapper.writeValueAsString(authUserDto);
        // log.info("Json : " + returnJson);
        assertThat(authUserDto).isNotNull();
        assertThat(authUserDto.getId().equals(id));
        log.info("Bye~");
    }
}
