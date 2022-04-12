package com.clinic.doctor.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.doctor.domain.CheckUpDetail;

public class CheckUpDetailRepository extends AbstractEntityRepository<CheckUpDetail> {
    public CheckUpDetailRepository() {
        super(CheckUpDetail.class);
    }

    @Override
    protected String tableName() {
        return "check_up_detail";
    }
}
