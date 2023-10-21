package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoleList() {
        String JPAql = "SELECT role FROM Role role";
        return entityManager.createQuery(JPAql, Role.class).getResultStream().collect(Collectors.toList());
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}