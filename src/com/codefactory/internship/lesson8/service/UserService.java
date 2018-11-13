package com.codefactory.internship.lesson8.service;

import com.codefactory.internship.lesson7.dao.UserDaoIntf;
import com.codefactory.internship.lesson7.dao.impl.CSVUserDaoImpl;
import com.codefactory.internship.lesson7.domain.User;
import com.codefactory.internship.lesson8.dto.UserDataDto;
import com.codefactory.internship.lesson8.execptions.UserNotFoundException;
import com.codefactory.internship.lesson8.mapping.UserMapper;
import com.codefactory.internship.lesson8.remote.RemoteService;

import java.util.List;

public class UserService {
    private UserDaoIntf userDao = new CSVUserDaoImpl();
    private RemoteService remoteService = new RemoteService();

    public UserDataDto getFullData(long userId) throws UserNotFoundException {
        // get local user data (UserDao)
        User user = getUserFromFile(userId);

        // get remote data (debts)
        boolean hasDebts = remoteService.hasUserDebts(userId);
        UserDataDto dto = UserMapper.from(user);

        dto.setHasDebts(hasDebts);

        return dto;
    }

    private User getUserFromFile(long userId) throws UserNotFoundException {
        List<User> allUsers = userDao.findAll();

        for (User user : allUsers) {
            if (user.getId() == userId) return user;
        }

        throw new UserNotFoundException("User with id " + userId + " wasn't found in database");
    }
}
