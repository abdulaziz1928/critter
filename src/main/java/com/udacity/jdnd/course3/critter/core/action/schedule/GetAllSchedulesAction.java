package com.udacity.jdnd.course3.critter.core.action.schedule;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllSchedulesAction {

    public List<Schedule> execute(){
        return null;
    }
}
