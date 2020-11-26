package com.carrent.service;

import com.carrent.dao.entities.User;
import com.carrent.dao.entities.UserAuth;
import com.carrent.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAuthService extends UserDetailsService {

    UserAuth getUserFromSecurityContext();

    UserAuth getUserDetails();

    UserAuth findUserByUsername(String name);



}
