package com.udacity.jdnd.course3.critter.core.domain.pet.service;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.pet.common.PetRepository;
import com.udacity.jdnd.course3.critter.core.domain.pet.exception.PetNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository repository;

    public Pet findPet(long id) {
        return repository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
    }

    @Override
    public List<Pet> findAllPets() {
        return repository.findAll();
    }

    @Override
    public List<Pet> findAllPetsByOwnerId(long ownerId) {
        return repository.getPetsByCustomerId(ownerId);
    }

    @Override
    public Pet savePet(Pet pet) {
        return null;
    }

}
