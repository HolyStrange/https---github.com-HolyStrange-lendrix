package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lendrix.entity.User;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>{

    User findByUsernameIgnoreCase(String username);

}
