package com.udacity.jdnd.course3.critter.web.resource.pet;

import com.udacity.jdnd.course3.critter.core.action.pet.GetPetAction;
import com.udacity.jdnd.course3.critter.core.action.pet.GetPetsAction;
import com.udacity.jdnd.course3.critter.core.action.pet.GetPetsByOwnerAction;
import com.udacity.jdnd.course3.critter.core.action.pet.SavePetAction;
import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/pet")
public class PetResource {

    private SavePetAction savePetAction;
    private GetPetAction getPetAction;
    private GetPetsAction getPetsAction;
    private GetPetsByOwnerAction getPetsByOwnerAction;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PetDTO> savePet(@RequestBody PetDTO petDTO) {
        var savedPet = savePetAction.execute(petDTO);
        var savedPetDTO = mapper.map(savedPet, PetDTO.class);
        return ResponseEntity.ok(savedPetDTO);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetDTO> getPet(@PathVariable long petId) {
        var pet = getPetAction.execute(petId);
        var petDTO = mapper.map(pet, PetDTO.class);
        return ResponseEntity.ok(petDTO);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getPets() {
        var pets = getPetsAction.execute();
        return getPetDTOS(pets);

    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PetDTO>> getPetsByOwner(@PathVariable long ownerId) {
        var pets = getPetsByOwnerAction.execute(ownerId);
        return getPetDTOS(pets);
    }

    private ResponseEntity<List<PetDTO>> getPetDTOS(List<Pet> pets) {
        var petDTOS = pets.stream()
                .map(pet -> mapper.map(pet, PetDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(petDTOS);
    }
}
