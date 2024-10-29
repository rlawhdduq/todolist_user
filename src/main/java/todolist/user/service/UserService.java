package todolist.user.service;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;

public interface UserService {

    LoginUserDto join(JoinUserDto joinUserDto);         // 회원가입
    LoginUserDto login(LoginUserDto loginUserDto);      // 로그인
}
