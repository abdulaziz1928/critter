package com.udacity.jdnd.course3.critter.core.domain.pet.common;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pet")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PetType type;

    @Nationalized
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    private Customer customer;

    private LocalDate birthDate;

    private String notes;

    @ManyToMany(targetEntity = Schedule.class)
    List<Schedule> schedules;


}
