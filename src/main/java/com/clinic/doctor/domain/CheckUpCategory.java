package com.clinic.doctor.domain;

import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import com.clinic.AbstractEntity;

public class CheckUpCategory extends AbstractEntity {
    public CheckUpCategory(Integer id) {
        super(id);
    }

    public CheckUpCategory() {
        super(null);
    }
    
    private Integer Id;
    private String category_name;


    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "id",
            "category_name");
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }


    public void category_name(String category_name) {
        this.category_name = category_name;
    }


    public Integer getId() {
        return Id;
    }

    public String category_name() {
        return category_name;
    }


}
