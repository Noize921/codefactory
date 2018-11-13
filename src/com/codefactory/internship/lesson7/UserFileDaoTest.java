package com.codefactory.internship.lesson7;

import com.codefactory.internship.lesson7.dao.impl.CSVUserDaoImpl;
import com.codefactory.internship.lesson7.domain.User;

import java.util.List;

public class UserFileDaoTest {
    public static void main(String[] args) {
        List<User> users = new CSVUserDaoImpl().findAll();

        for (User user : users) {
            System.out.println(String.format("%s, %s, %s", user.getId(), user.getFirstName(), user.getLastName()));
        }
    }
}
