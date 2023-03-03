package springoauth2.authorizationserver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springoauth2.authorizationserver.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
