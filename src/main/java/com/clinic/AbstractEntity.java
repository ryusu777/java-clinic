package com.clinic;

import java.util.List;

/**
 * Abstract class for creating entity class. <br>
 * This class is used for <code>AbstractRepository</code> to build queries. Here
 * are the main requirement for the entity class that derives from this class:
 * <ol>
 *  <li>
 *      Table fields should has getter and setter that is written in camelCase
 *  </li>
 *  <li>
 *      Super constructor should be called inside child's constructor for
 *      initializing the id of an entity. On default, id should be 
 *      <code>null</code>
 *  </li>
 * </ol>
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public abstract class AbstractEntity {
    private Integer id;

    public Integer getId() {
        return id;
    };

    /**
     * Get the field names for the table schema. This information is used for
     * building query. <br>
     * 
     * Field names should be defined in lower_case_snake_case. <br>
     * 
     * Do not override this function if you want to use the default function
     * of this class
     */
    public List<String> getTableFieldNames() {
        return null;
    }

    public AbstractEntity(Integer id) {
        this.id = id;
    }
}
