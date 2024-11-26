package todolist.user.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExceptionTest {

    // @Test
    public void exceptionTest()
    {
        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> {
            throw new DataNotFoundException("DB Fail");
        });

        assertEquals("DB Fail", exception.getMessage());
    }
}
