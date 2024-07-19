package com.udacity.jdnd.course3.critter.core.domain.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends IllegalArgumentException {

    private final Long id;

    public CustomerNotFoundException(Long id) {
        super();
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Customer with id %s not found", id);
    }
}
