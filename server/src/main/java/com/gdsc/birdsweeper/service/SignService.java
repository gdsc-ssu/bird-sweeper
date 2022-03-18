package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.domain.UserRole;
import com.gdsc.birdsweeper.dto.SignUpRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginResponseDTO;
import com.gdsc.birdsweeper.dto.UserResponseDTO;
import com.gdsc.birdsweeper.repository.UserRepository;
import com.gdsc.birdsweeper.security.jwt.JwtTokenProvider;
import com.gdsc.birdsweeper.utils.exception.LoginFailureException;
import com.gdsc.birdsweeper.utils.exception.UserNotFoundException;
import com.gdsc.birdsweeper.utils.exception.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SignService implements SignServiceImpl {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDTO signUp(SignUpRequestDTO SignUpRequestDTO){
        isUsernameDuplicated(SignUpRequestDTO.getUsername());

        User user = userRepository.save(User.builder()
                .username(SignUpRequestDTO.getUsername())
                .password(passwordEncoder.encode(SignUpRequestDTO.getPassword()))
                .name(SignUpRequestDTO.getName())
                .team(SignUpRequestDTO.getTeam())
                .phone(SignUpRequestDTO.getPhone())
                .email(SignUpRequestDTO.getEmail())
                .role(UserRole.ROLE_USER)
                .build());

        return UserResponseDTO.create(user);
    }

    @Override
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        User user = userRepository.findByUsername(userLoginRequestDTO.getUsername()).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(userLoginRequestDTO.getPassword(), user.getPassword())){
            throw new LoginFailureException();
        }
        return new UserLoginResponseDTO(user.getUsername(), jwtTokenProvider.generateToken(user));
    }

    private void isUsernameDuplicated(String username){
        if(userRepository.existsByUsername(username)){
            throw new UsernameAlreadyExistsException();
        }
    }
}
