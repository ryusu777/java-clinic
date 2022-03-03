package com.clinic.receptionist.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.receptionist.domain.Queue;

public class QueueRepository extends AbstractEntityRepository<Queue>{

    public QueueRepository() {
        super(Queue.class);
    }

    @Override
    protected String tableName() {
        return "queue";
    }
    
}
