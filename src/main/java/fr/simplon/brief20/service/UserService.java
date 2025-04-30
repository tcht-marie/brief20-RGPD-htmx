package fr.simplon.brief20.service;

import fr.simplon.brief20.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    List<User> findByRole(User.Role role);
    List<User> findAvailableEmployees();
    void deleteUser(Long id);
}
