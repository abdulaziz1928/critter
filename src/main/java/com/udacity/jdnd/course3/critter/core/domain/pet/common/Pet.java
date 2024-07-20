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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_seq", allocationSize = 1)
    private long id;
    private PetType type;
    @Nationalized
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    private LocalDate birthDate;
    private String notes;
    @ManyToMany(targetEntity = Schedule.class)
    List<Schedule> schedules;


}
