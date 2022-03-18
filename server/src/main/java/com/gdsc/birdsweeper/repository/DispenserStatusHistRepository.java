package com.gdsc.birdsweeper.repository;

import com.gdsc.birdsweeper.domain.Dispenser;
import com.gdsc.birdsweeper.domain.DispenserStatusHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispenserStatusHistRepository extends JpaRepository<DispenserStatusHist, Long> {

    List<DispenserStatusHist> findByDispenserIdOrderByIdDesc(Long dispenserId);
}
