package com.example.springapitask.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
           throw new IllegalArgumentException("User not found");
        }
        return userRepository.findById(id).orElse(null);
    }
    public void createUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User with id " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }
    public void deleteUser(Long id) {
        boolean isDeleted = userRepository.existsById(id);
        if (!isDeleted) {
            throw new IllegalArgumentException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }
    @Transactional
    public void updateUser(Long id, String name, String email, String city) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User with id " + id + " does not exist");
        }
        User user = userOptional.get();
        if (name != null) {
            user.setName(name);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (city != null) {
            user.setCity(city);
        }
        userRepository.save(user);
    }
}
