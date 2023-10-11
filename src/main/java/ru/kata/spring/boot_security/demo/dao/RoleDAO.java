package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.Set;

public interface RoleDAO {
    Set<Role> getAllRoles();

    Set<Role> getByName(String name);

    void saveRole(Role role);
}
