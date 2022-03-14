package com.gdsc.birdsweeper.dto;

import com.gdsc.birdsweeper.domain.Dispenser;
import com.gdsc.birdsweeper.domain.DispenserStatusHist;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class DispenserDetailResponseDTO {
    private Dispenser dispenser;
    private int version;
    private int feedPercent;
    private int trashPercent;
    private String motionStatus;
    private String motorStatus;
    private String createdDate;

    public static DispenserDetailResponseDTO create(DispenserStatusHist dispenserStatus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new DispenserDetailResponseDTO(dispenserStatus.getDispenser(),
                dispenserStatus.getVersion(), dispenserStatus.getFeedPercent(), dispenserStatus.getTrashPercent(),
                dispenserStatus.getMotionStatus().getValue(), dispenserStatus.getMotorStatus().getValue(),
                dispenserStatus.getCreatedDate().format(formatter));
    }
}
