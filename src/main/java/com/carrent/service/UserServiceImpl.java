package com.carrent.service;

import com.carrent.dao.entities.Role;
import com.carrent.dao.entities.User;
import com.carrent.dao.repository.UserRepository;
import com.carrent.dto.UserDTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(UserDTO userDto) throws DataAccessException {
        try {
            User user = new User(userDto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);

        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            userRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public List<UserDTO> findAll() throws DataAccessException {
        try {

            return userRepository.findAll()
                    .stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public UserDTO findUserById(Long id) throws DataAccessException {
        try {
            User userById = userRepository.findUserById(id);
            return new UserDTO(userById);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public boolean isExists(UserDTO user) throws DataAccessException {
        try {
            userRepository.findAll();
            return userRepository.findAll().stream()
                    .map(User::getUsername)
                    .anyMatch(name -> name.equals(user.getUsername()));
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public void deleteAdminRole(UserDTO user) {
        user.getRoles().remove(Role.ADMIN);
    }

    @Override
    public void addAdminRole(UserDTO user) {
        user.getRoles().add(Role.ADMIN);
    }


}
