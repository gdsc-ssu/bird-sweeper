package com.gdsc.birdsweeper.dto;

import com.gdsc.birdsweeper.domain.Dispenser;
import com.gdsc.birdsweeper.domain.DispenserStatusHist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispenserStatusRequestDTO {
    private String code;
    private int feedPercent;
    private int trashPercent;
    private String motionStatus;
    private String motorStatus;
}
