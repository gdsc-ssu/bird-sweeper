package com.gdsc.birdsweeper.dto;

import com.gdsc.birdsweeper.domain.Dispenser;
import com.gdsc.birdsweeper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class DispenserResponseDTO {
    private long id;
    private String code;
    private String location;
    private String latitude;
    private String longitude;
    private String status;
    private int feedCnt;
    private String createdUsername;
    private String createdDate;
    private String updatedDate;

    public static DispenserResponseDTO create(Dispenser dispenser) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new DispenserResponseDTO(dispenser.getId(), dispenser.getCode(),
                dispenser.getLocation(), dispenser.getLatitude(), dispenser.getLongitude(),
                dispenser.getStatus().getValue(), dispenser.getFeedCnt(), dispenser.getCreatedUser(),
                dispenser.getCreatedDate().format(formatter), dispenser.getUpdatedDate().format(formatter));
    }
}
