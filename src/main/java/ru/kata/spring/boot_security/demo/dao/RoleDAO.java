package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getByName(String name);

    void saveRole(Role role);

    List<Role> getRoleList();
}
