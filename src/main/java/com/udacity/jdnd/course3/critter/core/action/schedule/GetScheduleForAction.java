package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.ScheduleForType;
import com.udacity.jdnd.course3.critter.core.domain.schedule.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetScheduleForAction {
    private final ScheduleService scheduleService;

    public List<Schedule> execute(long id, ScheduleForType type) {
        switch (type) {
            case PET:
                return this.scheduleService.getScheduleForPet(id);
            case CUSTOMER:
                return this.scheduleService.getScheduleForCustomer(id);
            case EMPLOYEE:
                return this.scheduleService.getScheduleForEmployee(id);
            default:
                throw new IllegalArgumentException();
        }
    }
}
