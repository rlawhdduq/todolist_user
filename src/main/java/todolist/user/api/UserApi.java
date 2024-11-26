package todolist.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;
import todolist.user.dto.AuthUserDto;
import todolist.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserApi {

    @Autowired
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserApi.class);

    @PostMapping("/api/user/join")
    public AuthUserDto joinUser(@RequestBody JoinUserDto joinUserDto) {
        // 1. 호출할 땐 'DTO'를 설정해주면 DTO에 값이 맞춰져서 들어갈거다.
        // 2. service에서 Join 인터페이스를 상속받아 구현한다
        // 3. service.Join을 with 1번에서 들어온 DTO를 매개변수로 지정해서
        AuthUserDto authUserDto = userService.join(joinUserDto);
        // log.info("[UserApi] " + authUserDto.getId());
        return authUserDto;
    }
    
    @PostMapping("/api/user/login")
    public AuthUserDto loginUser(@RequestBody LoginUserDto loginUserDto) {
        AuthUserDto authUserDto = userService.login(loginUserDto);
        log.info("loginResult : " + authUserDto);
        return authUserDto;
    }
    
}
/**
 * 지금은 Dto로 반환하도록 해두었는데, 나중엔 Json객체를 암호화해서 넘길예정
 * -> 이건 필터써서 한번에 처리되도록 할거다. 그니까 여기선 수정안해도됨
 * -> 서버단에서 TLS로 암호화 하는 것 만으로도 충분하다고 한다... 정말~ 정말정말 중요한
 * 데이터 아니면 권장하진 않는다네 성능이슈 생길 수 있다고...
 */
