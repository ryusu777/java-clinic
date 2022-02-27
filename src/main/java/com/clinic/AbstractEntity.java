package com.clinic;

/**
 * Abstract class for creating entity class
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public abstract class AbstractEntity {
    private Integer id;

    public Integer getId() {
        return id;
    };

    public AbstractEntity(Integer id) {
        this.id = id;
    }
}
