package com.udacity.jdnd.course3.critter.core.domain.schedule.service;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllSchedules();

    Schedule createSchedule(Schedule schedule);

    List<Schedule> getScheduleForPet(long id);
    List<Schedule> getScheduleForCustomer(long id);
    List<Schedule> getScheduleForEmployee(long id);

}
