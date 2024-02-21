package com.udacity.jdnd.course3.critter.core.action.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.Set;

@Component
@AllArgsConstructor
public class SetAvailabilityAction {

    public void execute(Set<DayOfWeek> daysAvailable,long employeeId){

    }
}
