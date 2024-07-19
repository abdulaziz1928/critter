package com.udacity.jdnd.course3.critter.core.domain.pet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
