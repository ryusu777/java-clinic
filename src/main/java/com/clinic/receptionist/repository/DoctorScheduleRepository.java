package com.clinic.receptionist.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.receptionist.domain.DoctorSchedule;

public class DoctorScheduleRepository extends AbstractEntityRepository<DoctorSchedule>{

    public DoctorScheduleRepository() {
        super(DoctorSchedule.class);
    }

    @Override
    protected String tableName() {
        return "doctor_schedule";
    }
    
}
