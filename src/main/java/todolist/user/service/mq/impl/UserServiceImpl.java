package todolist.user.service.mq.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import todolist.user.repository.UserRepository;
import todolist.user.service.mq.UserService;
import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;
import todolist.user.exception.DataNotFoundException;
import todolist.user.dto.AuthUserDto;
import todolist.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("mqService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @Transactional
    public AuthUserDto join(JoinUserDto joinUserDto) {
        // TODO Auto-generated method stub
        User joinUser = User.builder()
                            .id(joinUserDto.getId())
                            .password(joinUserDto.getPassword())
                            .addr(joinUserDto.getAddr())
                            .addr_dt(joinUserDto.getAddr_dt())
                            .birth(joinUserDto.getBirth())
                            .ph(joinUserDto.getPh())
                            .gender(joinUserDto.getGender())
                            .build();
        
        
        User saveUser = userRepository.save(joinUser);

        AuthUserDto authUserDto = new AuthUserDto(
            saveUser.getUser_id(), saveUser.getId(),
            saveUser.getUser_type(),
            saveUser.getNumber_of_following(), saveUser.getNumber_of_follower()
            );
        return authUserDto;
    }

    @Override
    public AuthUserDto login(LoginUserDto loginUserDto) {
        AuthUserDto authUserDto = new AuthUserDto();
        authUserDto = userRepository.findUserOne(loginUserDto.getId(), loginUserDto.getPassword());
        return authUserDto;
    }

    @Override
    public AuthUserDto getUserInfo(Long user_id) {
        AuthUserDto authUserDto = userRepository.getUserInfo(user_id);
        return authUserDto;
    }
}
