package com.carrent.service;


import com.carrent.dao.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {


    void save(User user);

    void delete(Long id);

    List<User> findAll();

    User findUserById(Long id);

    User findUserByUsername(String name);

    boolean isExists(User user);

    void deleteAdminRole(User user);

    void addAdminRole(User user);

    User getUserFromSecurityContext();

    User getUserDetails();




}




