package com.carrent.service.service;

import com.carrent.dao.entities.User;
import com.carrent.dao.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service


public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    @Override
    public void delete(Long id) {
        userRepository.delete(id);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void getUserById(Long id) {

    }

    @Override
    public User getOne(String name) {
        return userRepository.findByName(name);
    }

}

