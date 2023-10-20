package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User updateUser);

    void deleteUser(Long id);

    User findByUserName(String username);

    User getUserById(Long id);

    List<User> getAllUsers();
}