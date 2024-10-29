package todolist.user.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.OptimisticLockException;
import todolist.user.repository.UserRepository;
import todolist.user.service.UserService;
import todolist.user.dto.JoinUserDto;
import todolist.user.dto.LoginUserDto;
import todolist.user.domain.User;
import lombok.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public LoginUserDto join(JoinUserDto joinUserDto) {
        // TODO Auto-generated method stub
        LoginUserDto loginUserDto = new LoginUserDto();
        try
        {
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
            loginUserDto.setUser_id(saveUser.getUser_id());
            loginUserDto.setId(saveUser.getId());
            // loginUserDto.setUser_type(saveUser.getUser_type());
            // loginUserDto.setScope_of_disclosure(saveUser.getScope_of_disclosure());
            // loginUserDto.setNumber_of_following(saveUser.getNumber_of_following());
            // loginUserDto.setNumber_of_follower(saveUser.getNumber_of_follower());

        }
        catch(DataIntegrityViolationException e)
        {
            // 데이터 무결성 위반 처리
        }
        catch(EntityExistsException e)
        {
            // 이미 존재하는 엔티티 일 경우 처리
        }
        // catch(TransactionRequiredException e){ // 트랜잭션 오류 처리 }
        catch(OptimisticLockException e){
            // 낙관적 병행제어 처리
        }
        catch(Exception e)
        {
            // 기타 예기치 않은 예외 처리
        }
        
        return loginUserDto;
    }

    @Override
    public LoginUserDto login(LoginUserDto loginUserDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
