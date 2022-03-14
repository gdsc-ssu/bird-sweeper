package com.gdsc.birdsweeper.service;

import com.gdsc.birdsweeper.domain.Dispenser;
import com.gdsc.birdsweeper.domain.DispenserStatusHist;
import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.domain.UserDispenser;
import com.gdsc.birdsweeper.dto.DispenserDetailResponseDTO;
import com.gdsc.birdsweeper.dto.DispenserRequestDTO;
import com.gdsc.birdsweeper.dto.DispenserResponseDTO;
import com.gdsc.birdsweeper.dto.DispenserStatusRequestDTO;
import com.gdsc.birdsweeper.repository.DispenserRepository;
import com.gdsc.birdsweeper.repository.DispenserStatusHistRepository;
import com.gdsc.birdsweeper.repository.UserDispenserRepository;
import com.gdsc.birdsweeper.utils.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DispenserService implements DispenserServiceImpl {

    private final UserDispenserRepository userDispenserRepository;
    private final DispenserRepository dispenserRepository;
    private final DispenserStatusHistRepository dispenserStatusHistRepository;

    @Override
    public DispenserResponseDTO findById(Long id) {
        Dispenser dispenser = dispenserRepository.findById(id).get();

        return DispenserResponseDTO.create(dispenser);
    }

    @Override
    public List<DispenserResponseDTO> getDispensersByUser(User user) {
        List<UserDispenser> userDispensers = userDispenserRepository.findByUser(user);

        return userDispensers.stream()
                .map(ud -> DispenserResponseDTO.create(ud.getDispenser()))
                .collect(Collectors.toList());
    }

    @Override
    public DispenserResponseDTO insertDispenser(DispenserRequestDTO dispenserRequestDTO, User user) {
        Dispenser dispenser = dispenserRepository.save(Dispenser.builder()
                .code(dispenserRequestDTO.getCode())
                .location(dispenserRequestDTO.getLocation())
                .latitude(dispenserRequestDTO.getLatitude())
                .longitude(dispenserRequestDTO.getLongitude())
                .status(Dispenser.Status.NORMAL)
                .feedCnt(0)
                .createdUser(user.getUsername())
                .build());

        return DispenserResponseDTO.create(dispenser);
    }

    @Override
    public DispenserResponseDTO bindingDispenserAndUser(Long dispenserId, User user) {
        Dispenser dispenser = dispenserRepository.findById(dispenserId).get();
        UserDispenser userDispenser = userDispenserRepository.save(new UserDispenser(user, dispenser));

        return DispenserResponseDTO.create(userDispenser.getDispenser());
    }

    @Override
    public DispenserDetailResponseDTO getDispenserDetail(Long dispenserId) {
        List<DispenserStatusHist> dispenserStatusHists = dispenserStatusHistRepository.findByDispenserIdOrderByIdDesc(dispenserId);
        if(dispenserStatusHists.size() == 0) {
            throw new ResourceNotFoundException("DispenserStatusHists is empty");
        }

        return DispenserDetailResponseDTO.create(dispenserStatusHists.get(0));
    }

    @Override
    public DispenserDetailResponseDTO insertDispenserStatus(DispenserStatusRequestDTO dispenserStatusRequestDTO) {
        Dispenser dispenser = dispenserRepository.findByCode(dispenserStatusRequestDTO.getCode()).get();
        List<DispenserStatusHist> dispenserStatusHists = dispenserStatusHistRepository.findByDispenserIdOrderByIdDesc(dispenser.getId());
        int version = dispenserStatusHists.size() > 0 ? dispenserStatusHists.get(0).getVersion() + 1 : 0;

        DispenserStatusHist dispenserStatus = dispenserStatusHistRepository.save(DispenserStatusHist.builder()
                .dispenser(dispenser)
                .version(version)
                .feedPercent(dispenserStatusRequestDTO.getFeedPercent())
                .trashPercent(dispenserStatusRequestDTO.getTrashPercent())
                .motionStatus(Dispenser.SensorStatus.valueOf(dispenserStatusRequestDTO.getMotionStatus()))
                .motorStatus(Dispenser.SensorStatus.valueOf(dispenserStatusRequestDTO.getMotorStatus()))
                .build());

        return DispenserDetailResponseDTO.create(dispenserStatus);
    }
}
