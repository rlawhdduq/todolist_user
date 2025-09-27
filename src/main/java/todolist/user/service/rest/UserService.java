package todolist.user.service.rest;

import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;

import org.springframework.stereotype.Service;

import todolist.user.dto.AuthUserDto;

@Service("restService")
public interface UserService {

    AuthUserDto join(JoinUserDto joinUserDto);         // 회원가입
    AuthUserDto login(LoginUserDto loginUserDto);      // 로그인
    AuthUserDto getUserInfo(Long user_id);                // 회원정보
}
