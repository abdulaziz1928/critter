package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.web.view.ScheduleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateScheduleAction {

    public Schedule execute(ScheduleDTO scheduleDTO){
        return null;
    }
}
