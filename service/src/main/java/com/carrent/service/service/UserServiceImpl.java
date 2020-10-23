package com.carrent.service.service;

import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import com.carrent.dao.repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public void save(User user) throws DataAccessException {
        try {
            userRepository.save(user);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            userRepository.delete(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public List<User> findAll() throws DataAccessException {
        try {
            userRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) throws DataAccessException {
        try {
            userRepository.findUserById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUsername(String name) throws DataAccessException {
        try {
            userRepository.findByUsername(name);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return userRepository.findByUsername(name);
    }


    @Override
    public boolean isExists(User user) throws DataAccessException {
        try {
            userRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return userRepository.findAll().stream()
                .map(User::getUsername)
                .allMatch(name -> name.equals(user.getUsername()));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        try {
            userRepository.findByUsername(username);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return userRepository.findByUsername(username);
    }
}
