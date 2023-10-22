package ru.kata.spring.boot_security.demo.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleDao roleDao;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public Init(RoleDao roleDao, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleDao.saveRole(userRole);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleDao.saveRole(adminRole);

        List<Role> userRoles = List.of(userRole);
        List<Role> adminRoles = List.of(adminRole);

        User admin = new User();
        admin.setUsername("Admin");
        admin.setLastname("Adminov");
        admin.setAge(42);
        admin.setEmail("admin@mail.ru");
        admin.setPassword(passwordEncoder.encode("1111"));
        admin.setRoles(adminRoles);
        userDao.saveUser(admin);

        User user = new User();
        user.setUsername("User");
        user.setLastname("Userov");
        user.setAge(25);
        user.setEmail("user@mail.ru");
        user.setPassword(passwordEncoder.encode("2222"));
        user.setRoles(userRoles);
        userDao.saveUser(user);
    }
}
