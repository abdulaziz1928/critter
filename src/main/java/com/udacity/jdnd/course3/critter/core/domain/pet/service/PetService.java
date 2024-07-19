package com.udacity.jdnd.course3.critter.core.domain.pet.service;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;

import java.util.List;

public interface PetService {

    Pet findPet(long id);

    List<Pet> findAllPets();

    List<Pet> findAllPetsByCustomerId(long ownerId);

    Pet savePet(Pet pet);
}
