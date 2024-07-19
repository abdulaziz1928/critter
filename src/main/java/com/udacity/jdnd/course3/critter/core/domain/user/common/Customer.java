package com.udacity.jdnd.course3.critter.core.domain.user.common;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String name;
    private String phoneNumber;
    private String notes;

    @OneToMany(targetEntity = Pet.class,fetch = FetchType.EAGER)
    private List<Pet> petList;
}
