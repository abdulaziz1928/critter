package com.udacity.jdnd.course3.critter.web.infrastructure.config;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.web.infrastructure.config.maps.CustomerMappings;
import com.udacity.jdnd.course3.critter.web.infrastructure.config.maps.ScheduleMappings;
import com.udacity.jdnd.course3.critter.web.view.CustomerDTO;
import com.udacity.jdnd.course3.critter.web.view.PetDTO;
import com.udacity.jdnd.course3.critter.web.view.ScheduleDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper
                .createTypeMap(ScheduleDTO.class, Schedule.class)
                .addMappings(
                        mapping -> {
                            mapping.using(ScheduleMappings.getIdToEmployeeMapper()).map(ScheduleDTO::getEmployeeIds, Schedule::setEmployees);
                            mapping.using(ScheduleMappings.getIdToPetMapper()).map(ScheduleDTO::getPetIds, Schedule::setPets);
                        });
        mapper
                .createTypeMap(Schedule.class, ScheduleDTO.class)
                .addMappings(
                        mapping -> {
                            mapping.using(ScheduleMappings.getEmployeeToIdMapper()).map(Schedule::getEmployees, ScheduleDTO::setEmployeeIds);
                            mapping.using(ScheduleMappings.getPetToIdMapper()).map(Schedule::getPets, ScheduleDTO::setPetIds);
                        });
        mapper
                .createTypeMap(Customer.class, CustomerDTO.class)
                .addMappings(
                        mapping ->
                                mapping.using(CustomerMappings.getPetToIdMapper()).map(Customer::getPetList, CustomerDTO::setPetIds)
                );
        mapper
                .createTypeMap(CustomerDTO.class, Customer.class)
                .addMappings(
                        mapping ->
                                mapping.using(CustomerMappings.getIdToPetMapper()).map(CustomerDTO::getPetIds, Customer::setPetList)
                );
        mapper
                .createTypeMap(Pet.class, PetDTO.class)
                        .addMappings(
                                mapping ->
                                        mapping.map(source -> source.getCustomer().getId(),PetDTO::setOwnerId)
                        );
        mapper
                .createTypeMap(PetDTO.class, Pet.class)
                .addMappings(
                        mapping ->
                                mapping.<Long>map(PetDTO::getOwnerId, Pet::setId)
                );
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}