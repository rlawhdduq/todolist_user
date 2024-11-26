package todolist.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import todolist.user.domain.User;
import todolist.user.dto.AuthUserDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select new todolist.user.dto.AuthUserDto(u.user_id, u.id, u.user_type, u.number_of_following, u.number_of_follower) From User as u Where u.id = :id and u.password = :password")
    AuthUserDto findUserOne(@Param("id") String id, @Param("password") String password);
}
