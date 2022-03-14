package com.gdsc.birdsweeper.controller;

import com.gdsc.birdsweeper.dto.SignUpRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginRequestDTO;
import com.gdsc.birdsweeper.dto.UserLoginResponseDTO;
import com.gdsc.birdsweeper.dto.UserResponseDTO;
import com.gdsc.birdsweeper.service.SignServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/sign")
@RestController
public class SignController {

    private final SignServiceImpl signService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(value = "/signUp")
    public ResponseEntity<UserResponseDTO> signUp(
            @RequestBody final SignUpRequestDTO signUpRequestDTO) {
        return new ResponseEntity<UserResponseDTO>(signService.signUp(signUpRequestDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<UserLoginResponseDTO> login(
            @RequestBody final UserLoginRequestDTO userLoginRequestDTO) {
        return new ResponseEntity<UserLoginResponseDTO>(signService.login(userLoginRequestDTO), HttpStatus.OK);
    }
}
