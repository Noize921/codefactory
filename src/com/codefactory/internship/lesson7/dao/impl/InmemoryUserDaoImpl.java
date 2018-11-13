package com.codefactory.internship.lesson7.dao.impl;

import com.codefactory.internship.lesson7.dao.UserDaoIntf;
import com.codefactory.internship.lesson7.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InmemoryUserDaoImpl implements UserDaoIntf {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
