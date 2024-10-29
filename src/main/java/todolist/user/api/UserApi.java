package todolist.user.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;

import todolist.user.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/api/join")
    public LoginUserDto joinUser(@RequestBody JoinUserDto joinUserDto) {
        // 1. 호출할 땐 'DTO'를 설정해주면 DTO에 값이 맞춰져서 들어갈거다.
        // 2. service에서 Join 인터페이스를 상속받아 구현한다
        // 3. service.Join을 with 1번에서 들어온 DTO를 매개변수로 지정해서
        LoginUserDto loginUserDto = userService.join(joinUserDto);
        return loginUserDto;
    }
    
}
