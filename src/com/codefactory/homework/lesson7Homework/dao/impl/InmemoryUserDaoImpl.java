package com.codefactory.homework.lesson7Homework.dao.impl;

import com.codefactory.homework.lesson7Homework.dao.UserDaoIntf;
import com.codefactory.homework.lesson7Homework.domain.User;


import java.util.ArrayList;
import java.util.List;

public class InmemoryUserDaoImpl implements UserDaoIntf {
    List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
