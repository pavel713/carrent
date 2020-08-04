package com.carrent.service.service;

import com.carrent.dao.entities.User;
import com.carrent.dao.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User client) {
        userRepository.save(client);
    }


    @Override
    public void delete(Long id) {
        userRepository.delete(id);

    }

    @Override
    public List<User> listUser() {
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

