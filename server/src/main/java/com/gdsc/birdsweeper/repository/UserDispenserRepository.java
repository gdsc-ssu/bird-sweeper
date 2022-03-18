package com.gdsc.birdsweeper.repository;

import com.gdsc.birdsweeper.domain.User;
import com.gdsc.birdsweeper.domain.UserDispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDispenserRepository extends JpaRepository<UserDispenser, Long> {

    Optional<UserDispenser> findById(Long id);

    List<UserDispenser> findByUser(User user);

    List<UserDispenser> findByDispenserId(Long dispenserId);
}
