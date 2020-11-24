package com.carrent.service;


import com.carrent.dao.entities.User;
import com.carrent.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {


    void save(UserDTO user);

    void delete(Long id);

    List<UserDTO> findAll();

    UserDTO findUserById(Long id);

    UserDTO findUserByUsername(String name);

    boolean isExists(UserDTO user);

    void deleteAdminRole(UserDTO user);

    void addAdminRole(UserDTO user);

    User getUserFromSecurityContext();

    User getUserDetails();




}




