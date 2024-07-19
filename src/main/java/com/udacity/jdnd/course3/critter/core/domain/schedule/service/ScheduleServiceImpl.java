package com.udacity.jdnd.course3.critter.core.domain.schedule.service;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.ScheduleRepository;
import com.udacity.jdnd.course3.critter.core.domain.schedule.exception.ScheduleNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository repository;

    public Schedule findScheduleById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
    }

    public List<Schedule> findAllSchedules() {
        return this.repository.findAll();
    }

    public Schedule createSchedule(Schedule schedule) {
        return this.repository.save(schedule);
    }

    @Override
    public List<Schedule> getScheduleForPet(long id) {
        return this.repository.findSchedulesByPets_Id(id);
    }

    @Override
    public List<Schedule> getScheduleForCustomer(long id) {
        return this.repository.findScheduleForCustomer(id);
    }

    @Override
    public List<Schedule> getScheduleForEmployee(long id) {
        return this.repository.findSchedulesByEmployees_Id(id);
    }
}
