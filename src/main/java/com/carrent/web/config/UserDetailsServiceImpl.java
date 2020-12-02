package com.carrent.web.config;

import com.carrent.dao.entities.UserAuth;
import com.carrent.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.carrent.dao.entities.User byUsername = userRepository.findByUsername(username);
        return new UserAuth(byUsername.getUsername(), byUsername.getPassword(), byUsername.getRoles());
    }
}
