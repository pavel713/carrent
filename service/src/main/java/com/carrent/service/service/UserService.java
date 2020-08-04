package com.carrent.service.service;


import com.carrent.dao.entities.User;


import java.util.List;

public interface UserService {


    void save(User user);

    void delete(Long id);

    List<User> listUser();

    void getUserById(Long id);

    User getOne(String name);


}




