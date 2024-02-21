package com.udacity.jdnd.course3.critter.core.domain.pet.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> getPetsByCustomerId(Long customer_id);
}
