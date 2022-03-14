package com.gdsc.birdsweeper.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDTO {
    private String username;
    private String password;
    private String name;
    private String team;
    private String phone;
    private String email;
}
