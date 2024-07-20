package com.udacity.jdnd.course3.critter.core.action.pet;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.pet.service.PetService;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class SavePetAction {

    private final ModelMapper mapper;
    private final PetService petService;
    private final UserService userService;

    @Transactional
    public Pet execute(PetDTO petDTO) {
        var customer = userService.findCustomerById(petDTO.getOwnerId());

        var pet = mapper.map(petDTO, Pet.class);
        pet.setCustomer(customer);

        var savedPet= petService.savePet(pet);
        customer.getPetList().add(savedPet);
        userService.saveCustomer(customer);

        return savedPet;
    }
}
