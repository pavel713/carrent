package com.carrent.dto;

import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.Role;
import com.carrent.dao.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String passport;

    private String address;

    private String phone;

    private String password;

    private String email;

    private Order order;

    private Set<Role> roles;

    public UserDTO() {
    }




    public UserDTO(User userDto) {
        this.id = userDto.getId();
        this.username = userDto.getUsername();
        this.passport = userDto.getPassport();
        this.address = userDto.getAddress();
        this.phone = userDto.getPhone();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.order = userDto.getOrder();
        this.roles = userDto.getRoles();


    }
}
