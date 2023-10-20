package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

    User findByUserName(String username);
}