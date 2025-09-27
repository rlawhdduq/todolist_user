package todolist.user.service.mq;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;

import todolist.user.dto.AuthUserDto;
public interface UserService {

    AuthUserDto join(JoinUserDto joinUserDto);         // 회원가입
    AuthUserDto login(LoginUserDto loginUserDto);      // 로그인
    AuthUserDto getUserInfo(Long user_id);                // 회원정보
}
