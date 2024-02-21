package com.udacity.jdnd.course3.critter.core.action.pet;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetPetsByOwnerAction {
    private final PetService petService;

    public List<Pet> execute(long ownerId){
        return petService.findAllPetsByOwnerId(ownerId);
    }
}
