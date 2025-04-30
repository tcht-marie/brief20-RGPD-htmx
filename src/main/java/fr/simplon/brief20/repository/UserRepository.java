package fr.simplon.brief20.repository;

import fr.simplon.brief20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByRole(User.Role role);
    List<User> findByAvailableTrueAndRole(User.Role role);
}
