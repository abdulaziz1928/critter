package com.udacity.jdnd.course3.critter.core.domain.user.common;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private long id;
    @Nationalized
    private String name;
    private String phoneNumber;
    private String notes;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pet> petList = new ArrayList<>();
}
