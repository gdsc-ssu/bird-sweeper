package com.gdsc.birdsweeper.controller;

import com.gdsc.birdsweeper.domain.UserRole;
import com.gdsc.birdsweeper.dto.UserResponseDTO;
import com.gdsc.birdsweeper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDTO> getUserInfo(
            @PathVariable String username) {
        return new ResponseEntity<UserResponseDTO>(userService.findByUsername(username), HttpStatus.OK);
    }
}
