package com.gdsc.birdsweeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispenserRequestDTO {
    private String code;
    private String location;
    private String latitude;
    private String longitude;
}
