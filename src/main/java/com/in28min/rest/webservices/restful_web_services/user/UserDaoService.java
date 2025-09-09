package com.in28min.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // JPA/Hibernate -> database
    // UserDaoService -> Static List of users

    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(usersCount++, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(usersCount++, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(usersCount++, "Jack", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.get(id);
    }

    public User save(User user) {
        user.setId(usersCount++);
        users.add(user);
        return user;
    }
}
