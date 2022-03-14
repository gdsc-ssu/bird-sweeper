package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.UserResponseDTO;
import com.gdsc.birdsweeper.repository.UserRepository;
import com.gdsc.birdsweeper.utils.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;

    @Override
    public User getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return user;
    }

    @Override
    public UserResponseDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return UserResponseDTO.create(user);
    }
}
