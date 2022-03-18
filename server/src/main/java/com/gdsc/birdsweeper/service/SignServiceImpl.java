package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.dto.SignUpRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginResponseDTO;
import com.gdsc.birdsweeper.dto.UserResponseDTO;

public interface SignServiceImpl {

    public UserResponseDTO signUp(SignUpRequestDTO signUpDTO);
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
