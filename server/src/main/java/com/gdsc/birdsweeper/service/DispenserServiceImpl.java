package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.DispenserDetailResponseDTO;
import com.gdsc.birdsweeper.dto.DispenserRequestDTO;
import com.gdsc.birdsweeper.dto.DispenserResponseDTO;
import com.gdsc.birdsweeper.dto.DispenserStatusRequestDTO;

import java.util.List;

public interface DispenserServiceImpl {

    public DispenserResponseDTO findById(Long id);

    public List<DispenserResponseDTO> getDispensersByUser(User user);

    public DispenserResponseDTO insertDispenser(DispenserRequestDTO dispenserRequestDTO, User user);

    public DispenserResponseDTO bindingDispenserAndUser(Long dispenserId, User uesr);


    public DispenserDetailResponseDTO getDispenserDetail(Long dispenserId);

    public DispenserDetailResponseDTO insertDispenserStatus(DispenserStatusRequestDTO dispenserStatusRequestDTO);
}
