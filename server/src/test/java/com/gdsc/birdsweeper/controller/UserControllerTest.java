package com.gdsc.birdsweeper.controller;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.SignUpRequestDTO;
import com.gdsc.birdsweeper.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private TestRestTemplate restTemplate;
    @Autowired private UserRepository userRepository;

    @AfterEach
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void signup_user() throws Exception {
        String username = "iamtest";
        String passowrd = "test1234!";
        String name = "테스트유저";
        String team = "GDSC Soongsil";
        String phone = "010-1111-2222";
        String email = "test@gdsc.com";

        SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
        signUpRequestDTO.setUsername(username);
        signUpRequestDTO.setPassword(passowrd);
        signUpRequestDTO.setName(name);
        signUpRequestDTO.setTeam(team);
        signUpRequestDTO.setPhone(phone);
        signUpRequestDTO.setEmail(email);

        String url = "http://localhost:" + port + "/api/sign/signUp";

        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, signUpRequestDTO, User.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getUsername()).isEqualTo(username);
        assertThat(users.get(0).getPassword()).isEqualTo(passowrd);
        assertThat(users.get(0).getName()).isEqualTo(name);
        assertThat(users.get(0).getTeam()).isEqualTo(team);
        assertThat(users.get(0).getPhone()).isEqualTo(phone);
        assertThat(users.get(0).getEmail()).isEqualTo(email);
    }
}
