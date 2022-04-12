package com.clinic.doctor.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.doctor.domain.CheckUpCategory;

public class CheckUpCategoryRepository extends AbstractEntityRepository<CheckUpCategory> {
    public CheckUpCategoryRepository() {
        super(CheckUpCategory.class);
    }

    @Override
    protected String tableName() {
        return "check_up_category";
    }
}
