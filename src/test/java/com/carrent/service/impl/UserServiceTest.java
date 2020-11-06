package com.carrent.service.impl;

import com.carrent.dao.entities.User;
import com.carrent.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest {


    @Autowired
    UserService userService;


    @Test
    void getById() {
        Assert.assertNotNull(1);
    }}