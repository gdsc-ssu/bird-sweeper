package com.gdsc.birdsweeper.controller;

import com.gdsc.birdsweeper.domain.MyUserDetails;
import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.dto.*;
import com.gdsc.birdsweeper.service.DispenserService;
import com.gdsc.birdsweeper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/dispenser")
@RestController
public class DispenserController {

    private final UserService userService;
    private final DispenserService dispenserService;

    @GetMapping
    public ResponseEntity<List<DispenserResponseDTO>> getDispensersByUser(
            @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.getUser(userDetails.getUsername());

        return new ResponseEntity<List<DispenserResponseDTO>>(dispenserService.getDispensersByUser(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DispenserResponseDTO> insertDispenser(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody DispenserRequestDTO dispenserRequestDTO) {
        User user = userService.getUser(userDetails.getUsername());
        return new ResponseEntity<DispenserResponseDTO>(dispenserService.insertDispenser(dispenserRequestDTO, user), HttpStatus.OK);
    }

    @PostMapping("/{dispenserId}/user")
    public ResponseEntity<DispenserResponseDTO> bindingDispenserAndUser(
            @PathVariable Long dispenserId,
            @RequestParam String username) {
        User user = userService.getUser(username);

        return new ResponseEntity<DispenserResponseDTO>(dispenserService.bindingDispenserAndUser(dispenserId, user), HttpStatus.OK);
    }

    @GetMapping("/{dispenserId}")
    public ResponseEntity<DispenserDetailResponseDTO> getDispenserDetail(
            @PathVariable Long dispenserId) {
        return new ResponseEntity<DispenserDetailResponseDTO>(dispenserService.getDispenserDetail(dispenserId), HttpStatus.OK);
    }

    @PostMapping("/{dispenserId}")
    public ResponseEntity<DispenserDetailResponseDTO> insertDispenserStatus(
            @RequestBody DispenserStatusRequestDTO dispenserStatusRequestDTO) {
        return new ResponseEntity<DispenserDetailResponseDTO>(dispenserService.insertDispenserStatus(dispenserStatusRequestDTO), HttpStatus.OK);
    }
}
