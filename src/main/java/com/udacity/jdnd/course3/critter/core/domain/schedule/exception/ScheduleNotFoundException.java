package com.udacity.jdnd.course3.critter.core.domain.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ScheduleNotFoundException extends IllegalArgumentException {
    private final Long id;
    public ScheduleNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {

        return String.format("Schedule with Id=(%s) Not Found", id);
    }
}
