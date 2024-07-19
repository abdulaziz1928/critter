package com.udacity.jdnd.course3.critter.web.infrastructure.config.maps;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import org.modelmapper.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMappings {
    public static Converter<List<Long>, List<Pet>> getIdToPetMapper() {
        return context -> {
            List<Long> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(val -> Pet.builder().id(val).build()).collect(Collectors.toList());
        };
    }

    public static Converter<List<Pet>, List<Long>> getPetToIdMapper() {
        return context -> {
            List<Pet> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(Pet::getId).collect(Collectors.toList());
        };
    }
}
