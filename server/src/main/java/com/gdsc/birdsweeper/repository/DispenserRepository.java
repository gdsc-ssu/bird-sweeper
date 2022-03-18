package com.gdsc.birdsweeper.repository;

import com.gdsc.birdsweeper.domain.Dispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispenserRepository extends JpaRepository<Dispenser, Long> {

    Optional<Dispenser> findById(Long id);

    Optional<Dispenser> findByCode(String code);
}
