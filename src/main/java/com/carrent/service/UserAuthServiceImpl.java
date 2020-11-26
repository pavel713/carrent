package com.carrent.service;

import com.carrent.dao.entities.UserAuth;
import com.carrent.dao.repository.UserAuthRepository;
import com.carrent.dto.UserDTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserAuthServiceImpl implements UserAuthService, UserDetailsService {
    private final UserAuthRepository userAuthRepository;

    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserAuth getUserFromSecurityContext() throws DataAccessException {
        try {
            String username = getUserDetails().getUsername();
            return userAuthRepository.findByUsername(username);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public UserAuth getUserDetails() {
        return (UserAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        try {
            userAuthRepository.findByUsername(username);
            return userAuthRepository.findByUsername(username);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public UserAuth findUserByUsername(String name) throws DataAccessException {
        try {
            userAuthRepository.findAll();
            return (UserAuth) userAuthRepository.findAll().stream()
                    .map(UserAuth::new);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


}
