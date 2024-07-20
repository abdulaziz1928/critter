package com.udacity.jdnd.course3.critter.web.resource.schedule;

import com.udacity.jdnd.course3.critter.core.action.schedule.*;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import com.udacity.jdnd.course3.critter.core.domain.schedule.common.ScheduleForType;
import com.udacity.jdnd.course3.critter.web.view.ScheduleDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleResource {

    private CreateScheduleAction createScheduleAction;
    private GetAllSchedulesAction getAllSchedulesAction;
    private GetScheduleForAction getScheduleForAction;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        var createdSchedule = createScheduleAction.execute(scheduleDTO);
        var createdScheduleDTO = mapper.map(createdSchedule, ScheduleDTO.class);
        return ResponseEntity.ok(createdScheduleDTO);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
        var schedules = getAllSchedulesAction.execute();
        var scheduleDTOS = getScheduleDTOS(schedules);
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<ScheduleDTO>> getScheduleForPet(@PathVariable("petId") long petId) {
        return getSchedules(petId, ScheduleForType.PET);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ScheduleDTO>> getScheduleForEmployee(@PathVariable long employeeId) {
        return getSchedules(employeeId, ScheduleForType.EMPLOYEE);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ScheduleDTO>> getScheduleForCustomer(@PathVariable long customerId) {
        return getSchedules(customerId, ScheduleForType.CUSTOMER);
    }

    private ResponseEntity<List<ScheduleDTO>> getSchedules(long id, ScheduleForType type) {
        var schedules = getScheduleForAction.execute(id, type);
        var scheduleDTOS = getScheduleDTOS(schedules);
        return ResponseEntity.ok(scheduleDTOS);
    }

    private List<ScheduleDTO> getScheduleDTOS(List<Schedule> schedules) {
        return schedules.stream()
                .map(schedule -> mapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());
    }


}
