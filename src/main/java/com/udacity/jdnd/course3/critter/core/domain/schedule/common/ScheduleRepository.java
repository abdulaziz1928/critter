package com.udacity.jdnd.course3.critter.core.domain.schedule.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findSchedulesByPets_Id(Long pets_id);
    List<Schedule> findSchedulesByEmployees_Id(long employees_id);
    @Query("select s from Schedule s join s.pets p where p.customer.id = :customerId")
    List<Schedule> findScheduleForCustomer(@Param("customerId") long customerId);

}
