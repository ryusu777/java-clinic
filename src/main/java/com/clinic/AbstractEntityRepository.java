package com.clinic;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for creating an entity repository. Provides basic CRUD
 * function.
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public abstract class AbstractEntityRepository<T extends AbstractEntity> extends ClinicConnection {
    /**
     * Get an entity by id
     * @param id the id of the entity
     */
    public T get(int id) throws SQLException {
        ResultSet queryResult = query("SELECT * FROM " + tableName()
            + " WHERE id=" + id + ";");
        return mapEntity(queryResult);
    }

    /**
     * Delete a record in the database
     * @param id
     * @return
     */
    public boolean delete(int id) throws SQLException {
        return excecute("DELETE FROM " + tableName() + " WHERE id=" + id + ";");
    }

    /**
     * Get list of entity records with pagination
     * @param pagination
     * @return <code>List<T></code> with T as the entity type
     * @throws SQLException
     */
    public List<T> get(Pagination pagination) throws SQLException {
        ResultSet queryResult = query("SELECT * FROM " + tableName() + ";");
        List<T> entities = new ArrayList<>();
        while (queryResult.next()) {
            entities.add(mapEntity(queryResult));
        }
        return entities;
    }

    /**
     * Edit the entity in the database.
     * @param entity
     * @return <code>boolean</code> representing successfully edited or not
     * @throws SQLException
     */
    protected boolean edit(T entity) throws SQLException {
        String query = "UPDATE " + tableName() + " SET ";
        try {
            for (Map.Entry<String, Method> field 
                : getEntityAttributesInSnakeCase(entity.getClass()).entrySet()) {
                query += (
                    field.getKey() + "=" + field.getValue().invoke(entity)
                    + ", "
                );
            }
            query = query.replaceFirst(",\\s$", " WHERE id=" + entity.getId()
                + ";");
            
            return excecute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Maps a <code>ResultSet</code> into a single entity
     * @param queryResult the result of getting an entity
     */
    protected abstract T mapEntity(ResultSet queryResult);

    /**
     * Gets a <code>Map</code> with snake cased database's field names as key 
     * and the getter method for the entity class as value
     * @param theClass
     * @return <code>Map<String, Method></code>
     */
    private Map<String, Method> getEntityAttributesInSnakeCase(Class<?> theClass) {
        Map<String, Method> result = new HashMap<String, Method>();
        String excludedGetters = "getId";
        for (Method method : theClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)
                && method.getName().matches("get\\D+")
                && !method.getName().matches(excludedGetters)) {
            
                result.put(
                    method
                        .getName()
                        .substring(3)
                        .replaceAll("([a-z])([A-Z])", "$1_$2")
                        .toLowerCase(),
                    method);
            }
        }
        return result;
    }

    /**
     * Get the name of the table in the database
     */
    protected abstract String tableName();
}
