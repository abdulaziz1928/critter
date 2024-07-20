package com.udacity.jdnd.course3.critter.web.infrastructure.config.mappings;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import org.modelmapper.Converter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ScheduleMappings {
    public static Converter<List<Long>, Set<Employee>> getIdToEmployeeMapper() {
        return context -> {
            List<Long> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(val -> Employee.builder().id(val).build()).collect(Collectors.toSet());
        };
    }

    public static Converter<Set<Employee>, List<Long>> getEmployeeToIdMapper() {
        return context -> {
            Set<Employee> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(Employee::getId).collect(Collectors.toList());
        };
    }

    public static Converter<List<Long>, Set<Pet>> getIdToPetMapper() {
        return context -> {
            List<Long> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(val -> Pet.builder().id(val).build()).collect(Collectors.toSet());
        };
    }

    public static Converter<Set<Pet>, List<Long>> getPetToIdMapper() {
        return context -> {
            Set<Pet> source = context.getSource();
            if (source == null) {
                return null;
            }
            return source.stream().map(Pet::getId).collect(Collectors.toList());
        };
    }
}
