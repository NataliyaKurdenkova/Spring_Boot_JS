package ru.project.restapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.project.restapp.model.Role;
import ru.project.restapp.model.User;
import ru.project.restapp.service.EntityService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class RestAppApplication {

    public static EntityService<User> userService;

    public static EntityService<Role> roleService;

    @Autowired
    public RestAppApplication(EntityService<User> userService, EntityService<Role> roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    public static void main(String[] args) {
        SpringApplication.run(RestAppApplication.class, args);
        startValue();
    }

    public static void startValue() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        roleService.save(adminRole);
        roleService.save(userRole);

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        roles.add(userRole);
        User adminUser = new User("admin", "admin", 35, "admin@mail.ru", "admin", roles);
        userService.save(adminUser);
    }


}
