package todolist.user.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import todolist.user.domain.User;
import todolist.user.dto.AuthUserDto;

@Repository
public interface UserQueryMethod extends JpaRepository<User, Long>{
    
    @Query("Select new todolist.user.dto.AuthUserDto(u.user_id, u.id, u.user_type, u.scope_of_disclosure, u.number_of_following, u.number_of_follower) From User as u Where u.id = :id and u.password = :password")
    AuthUserDto findUserOne(@Param("id") String id, @Param("password") String password);
}

/**
 *  @Query 어노테이션 from절의 테이블은 스프링 부트단에서는 JPA객체를 의미하고, DB에서는 Table명을 뜻한다. findUserOne을 예시로 들자면, From User에서 SpringBoot = User.java / DB = user 테이블을 의미한다.
 *  즉, 해당 테이블과 매핑될 수 있는 JPA객체가 있어야 한다. 해당 객체 없으면 조회가 불가능함.
 * 
 */
