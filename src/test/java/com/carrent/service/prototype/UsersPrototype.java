package com.carrent.service.prototype;

import com.carrent.dao.entities.User;
import com.carrent.dto.UserDTO;


public class UsersPrototype {

    public static User aUser() {
        User user = new User();
        user.setUsername("Alex");
        user.setEmail("alex@tut.by");
        return user;
    }

    public static UserDTO aUserDTO() {
        return UserDTO.builder()
                .username("Alex")
                .email("alex@tut.by")
                .build();
    }
}
