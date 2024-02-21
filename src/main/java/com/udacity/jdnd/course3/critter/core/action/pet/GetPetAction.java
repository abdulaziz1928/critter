package com.udacity.jdnd.course3.critter.core.action.pet;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPetAction {

    private final PetService petService;

    public Pet execute(long id){
        return petService.findPet(id);
    }
}
