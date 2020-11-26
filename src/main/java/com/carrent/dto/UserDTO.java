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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
