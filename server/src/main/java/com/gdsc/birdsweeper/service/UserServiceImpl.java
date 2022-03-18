package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.UserResponseDTO;

public interface UserServiceImpl {

    public User getUser(String username);
    public UserResponseDTO findByUsername(String username);
}
