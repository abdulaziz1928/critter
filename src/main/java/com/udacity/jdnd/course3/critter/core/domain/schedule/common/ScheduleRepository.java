package com.udacity.jdnd.course3.critter.core.domain.schedule.common;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
