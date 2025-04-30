package fr.simplon.brief20.service.impl;

import fr.simplon.brief20.model.User;
import fr.simplon.brief20.repository.UserRepository;
import fr.simplon.brief20.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) { // avoid double encoding
            user.setPassword(user.getPassword());
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(User.Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findAvailableEmployees() {
        return userRepository.findByAvailableTrueAndRole(User.Role.EMPLOYEE);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
