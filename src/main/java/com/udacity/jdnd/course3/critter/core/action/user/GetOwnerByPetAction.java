package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetOwnerByPetAction {
    private final PetService petService;

    public Customer execute(long petId){
        var pet = petService.findPet(petId);
        return pet.getCustomer();
    }
}
