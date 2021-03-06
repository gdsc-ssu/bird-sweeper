package com.gdsc.birdsweeper.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "dispenser_status_hist")
@Entity
public class DispenserStatusHist extends AutoGeneratedId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dispenser_id")
    private Dispenser dispenser;

    @Column(nullable = false)
    private Integer version;

    @Column
    private Integer feedPercent;

    @Column
    private Integer trashPercent;

    @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private Dispenser.SensorStatus motionStatus;

    @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private Dispenser.SensorStatus motorStatus;

    @CreationTimestamp
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime createdDate;
}
