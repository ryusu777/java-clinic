package com.clinic.receptionist.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.receptionist.domain.Appointment;

public class AppointmentRepository extends AbstractEntityRepository<Appointment>{

    public AppointmentRepository() {
        super(Appointment.class);
    }

    @Override
    protected String tableName() {
        return "appointment";
    }
    
}