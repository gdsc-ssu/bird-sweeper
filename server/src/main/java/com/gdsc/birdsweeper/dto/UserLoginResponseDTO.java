package com.gdsc.birdsweeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserLoginResponseDTO {
    String username;
    String token;
}
