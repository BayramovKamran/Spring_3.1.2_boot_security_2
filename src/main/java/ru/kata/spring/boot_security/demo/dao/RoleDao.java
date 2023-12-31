package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

public interface RoleDao {

    void saveRole(Role role);

    List<Role> getRoleList();

    Role getByName(String role);
}
