package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllSchedulesAction {
    private final ScheduleService scheduleService;

    public List<Schedule> execute() {
        return scheduleService.findAllSchedules();
    }
}
