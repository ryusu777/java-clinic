package com.clinic.doctor.domain;

import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;

public class CheckUpCategory extends AbstractEntity {
    public CheckUpCategory(Integer id) {
        super(id);
    }

    public CheckUpCategory() {
        super(null);
    }
    
    private Integer id;
    private String categoryName;


    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "id",
            "category_name");
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }


}
