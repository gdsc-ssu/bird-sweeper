package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.MyUserDetails;
import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.repository.UserRepository;
import com.gdsc.birdsweeper.utils.exception.LoginFailureException;
import com.gdsc.birdsweeper.utils.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return MyUserDetails.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())))
                .build();
    }
}
