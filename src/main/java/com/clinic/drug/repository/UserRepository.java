package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.User;

public class UserRepository extends AbstractEntityRepository<User> {
    public UserRepository() {
        super(User.class);
    }

    @Override
    protected String tableName() {
        return "user";
    }
}
