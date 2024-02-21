package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.ScheduleForType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetScheduleForAction {

    public List<Schedule> execute(long id, ScheduleForType type) {
        return null;
    }
}
