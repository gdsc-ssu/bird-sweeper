package com.gdsc.birdsweeper.dto;

import com.gdsc.birdsweeper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String username;
    private String password;
    private String name;
    private String team;
    private String phone;
    private String email;

    public static UserResponseDTO create(User user) {
        return new UserResponseDTO(user.getUsername(), user.getPassword(),
                user.getName(), user.getTeam(), user.getPhone(), user.getEmail());
    }
}
