package com.carrent.service;


import com.carrent.dto.UserDTO;

import java.util.List;

public interface UserService {


    void save(UserDTO user);

    void delete(Long id);

   List<UserDTO> findAll();

    UserDTO findUserById(Long id);

    boolean isExists(UserDTO user);

    void deleteAdminRole(UserDTO user);

    void addAdminRole(UserDTO user);






}




