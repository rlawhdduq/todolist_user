package todolist.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
