package com.in28minutes.rest.webservices.restfulwebservices.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.models.User;

// This annotation is used to indicate that the class provides the mechanism for storage,
// retrieval, update, delete and search operation on objects.
@Repository
public class UserRepository {
    private static List<User> users = new ArrayList<>();
    public static int userCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> getUsers() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        user.setbirthDate(new Date());
        users.add(user);
        return user;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return User.emptyUser();
    }

    public User deleteUser(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return User.emptyUser();
    }
}
