package com.gdsc.birdsweeper.repository;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.domain.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void save_user_and_get_all_users() {
        String username = "iamtest";
        String passowrd = "test1234!";
        String name = "테스트유저";
        String team = "GDSC Soongsil";
        String phone = "010-1111-2222";
        String email = "test@gdsc.com";
        UserRole role = UserRole.ROLE_USER;

        userRepository.save(User.builder()
                .username(username)
//                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .password(passowrd)
                .name(name)
                .team(team)
                .phone(phone)
                .email(email)
                .role(role)
                .build());

        List<User> users = userRepository.findAll();

        User user = users.get(0);
        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), passowrd);
        assertEquals(user.getName(), name);
        assertEquals(user.getTeam(), team);
        assertEquals(user.getPhone(), phone);
        assertEquals(user.getEmail(), email);
        assertEquals(user.getRole(), role);
    }
}