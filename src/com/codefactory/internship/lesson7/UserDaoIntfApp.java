package com.codefactory.internship.lesson7;

import com.codefactory.internship.lesson7.dao.UserDaoIntf;
import com.codefactory.internship.lesson7.dao.impl.CSVUserDaoImpl;
import com.codefactory.internship.lesson7.dao.impl.InmemoryUserDaoImpl;
import com.codefactory.internship.lesson7.domain.User;

import java.util.List;

public class UserDaoIntfApp {
    public static void main(String[] args) {
        List<User> users;
        UserDaoIntf userDao = new InmemoryUserDaoImpl();
        User user1 = new User(1L, "John", "Doe");
        User user2 = new User(2L, "Michel", "Douglas");

        userDao.save(user1);
        userDao.save(user2);

        users = userDao.findAll();

        userDao = new CSVUserDaoImpl();

        userDao.save(user1);
        userDao.save(user2);
    }
}
