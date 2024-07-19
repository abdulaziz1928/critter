package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetOwnerByPetAction {
    private final PetService petService;
    private final UserService userService;

    public Customer execute(long petId){
        var pet = petService.findPet(petId);
        return this.userService.findCustomerById(pet.getCustomer().getId());
    }
}
