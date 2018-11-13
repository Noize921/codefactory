package com.codefactory.internship.lesson7.dao;

import com.codefactory.internship.lesson7.domain.User;

import java.util.List;

public interface UserDaoIntf {
    void save(User user);
    List<User> findAll();
}
