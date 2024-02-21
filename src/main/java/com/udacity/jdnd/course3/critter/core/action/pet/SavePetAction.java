package com.udacity.jdnd.course3.critter.core.action.pet;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SavePetAction {

    private final ModelMapper mapper;
    private final PetService petService;
    private final UserService userService;

    public Pet execute(PetDTO petDTO){
        Customer owner= userService.findCustomerById(petDTO.getOwnerId());
        Pet pet=mapper.map(petDTO, Pet.class);
        pet.setCustomer(owner);
        return petService.savePet(pet);
    }
}
