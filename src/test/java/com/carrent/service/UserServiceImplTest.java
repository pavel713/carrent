package com.carrent.service;

import com.carrent.dao.repository.UserRepository;
import com.carrent.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static com.carrent.service.prototype.UsersPrototype.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {


    private UserRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private MailServiceImpl mailService;

    private UserService usersService;


    @BeforeEach
    void setUp() {
        usersRepository = mock(UserRepository.class);
        usersService = new UserServiceImpl(usersRepository, passwordEncoder, mailService);
    }


    @Test
    void findAll() {
        List<UserDTO> findAllUsers = usersService.findAll();
        assertThat(findAllUsers).isNotNull();

    }

    @Test
    void deleteUser() {
        when(usersRepository.findByUsername(eq("Alex"))).thenReturn(aUser());
        UserDTO deleteUser = usersService.delete((long) 1);
        assertThat(deleteUser).isNull();

    }

    @Test
    void findByName() {
        when(usersRepository.findByUsername(eq("Alex"))).thenReturn(aUser());
        UserDTO foundUser = usersService.findUserByName("Alex");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("Alex");
    }


}