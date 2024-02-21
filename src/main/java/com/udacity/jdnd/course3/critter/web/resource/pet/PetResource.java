package com.udacity.jdnd.course3.critter.web.resource.pet;

import com.udacity.jdnd.course3.critter.core.action.pet.GetPetAction;
import com.udacity.jdnd.course3.critter.core.action.pet.GetPetsAction;
import com.udacity.jdnd.course3.critter.core.action.pet.GetPetsByOwnerAction;
import com.udacity.jdnd.course3.critter.core.action.pet.SavePetAction;
import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import com.udacity.jdnd.course3.critter.web.view.ScheduleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetResource {

    private SavePetAction savePetAction;
    private GetPetAction getPetAction;
    private GetPetsAction getPetsAction;
    private GetPetsByOwnerAction getPetsByOwnerAction;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PetDTO> savePet(@RequestBody PetDTO petDTO) {
        Pet savedPet = savePetAction.execute(petDTO);
        PetDTO savedPetDTO = mapper.map(savedPet, PetDTO.class);
        return ResponseEntity.ok(savedPetDTO);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetDTO> getPet(@PathVariable long petId) {
        Pet pet = getPetAction.execute(petId);
        PetDTO petDTO = mapper.map(pet, PetDTO.class);
        return ResponseEntity.ok(petDTO);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getPets() {
        List<Pet> pets = getPetsAction.execute();
        List<PetDTO> petDTOS = getPetDTOS(pets);
        return ResponseEntity.ok(petDTOS);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PetDTO>> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = getPetsByOwnerAction.execute(ownerId);
        List<PetDTO> petDTOS = getPetDTOS(pets);
        return ResponseEntity.ok(petDTOS);
    }

    private List<PetDTO> getPetDTOS(List<Pet> pets) {
        return pets.stream()
                .map(pet -> mapper.map(pet, PetDTO.class))
                .collect(Collectors.toList());
    }
}
