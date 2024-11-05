package todolist.user.service;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;
import todolist.user.dto.AuthUserDto;

public interface UserService {

    AuthUserDto join(JoinUserDto joinUserDto);         // 회원가입
    AuthUserDto login(LoginUserDto loginUserDto);      // 로그인
}
