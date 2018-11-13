package com.codefactory.homework.lesson7Homework.dao;

import com.codefactory.homework.lesson7Homework.domain.User;

import java.util.List;

public interface UserDaoIntf {
    void save(User user);
    List<User> findAll();
}
