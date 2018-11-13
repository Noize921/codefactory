package com.codefactory.internship.lesson8.mapping;

import com.codefactory.internship.lesson7.domain.User;
import com.codefactory.internship.lesson8.dto.UserDataDto;

public class UserMapper {


    public static UserDataDto from(User user) {
        UserDataDto dto = new UserDataDto();

        dto.setId(user.getId());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());

        return dto;
    }
}
