package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.SignUpRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginResponseDTO;
import com.gdsc.birdsweeper.dto.UserResponseDTO;

public interface SignService {

    public UserResponseDTO signUp(SignUpRequestDTO signUpDTO);
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
