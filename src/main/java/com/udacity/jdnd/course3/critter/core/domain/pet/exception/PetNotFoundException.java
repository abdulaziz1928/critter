package com.udacity.jdnd.course3.critter.core.domain.pet.exception;

public class PetNotFoundException extends IllegalArgumentException {
    private final Long id;
    public PetNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {

        return String.format("Pet with Id=(%s) Not Found", id);
    }
}
