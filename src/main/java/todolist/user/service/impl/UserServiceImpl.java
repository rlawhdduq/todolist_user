package todolist.user.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import todolist.user.repository.UserRepository;
import todolist.user.service.UserService;
import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;
import todolist.user.exception.DataNotFoundException;
import todolist.user.query.UserQueryMethod;
import todolist.user.dto.AuthUserDto;
import todolist.user.domain.User;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserQueryMethod userQueryMethod;
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
            saveUser.getUser_type(), saveUser.getScope_of_disclosure(),
            saveUser.getNumber_of_following(), saveUser.getNumber_of_follower()
            );
        return authUserDto;
    }

    @Override
    public AuthUserDto login(LoginUserDto loginUserDto) {
        AuthUserDto authUserDto = new AuthUserDto();
        authUserDto = userQueryMethod.findUserOne(loginUserDto.getId(), loginUserDto.getPassword());
        if( authUserDto == null ) throw new DataNotFoundException("유효하지 않은 사용자 정보");
        return authUserDto;
    }
}
