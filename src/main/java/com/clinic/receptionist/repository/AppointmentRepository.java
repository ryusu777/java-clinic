package com.clinic.receptionist.repository;


import com.clinic.abstracts.AbstractEntityRepository;
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