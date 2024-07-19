package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.service.ScheduleService;
import com.udacity.jdnd.course3.critter.web.view.ScheduleDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateScheduleAction {
    private final ModelMapper mapper;
    private final ScheduleService scheduleService;

    public Schedule execute(ScheduleDTO scheduleDTO){
        var schedule=mapper.map(scheduleDTO,Schedule.class);
        return scheduleService.createSchedule(schedule);
    }
}
