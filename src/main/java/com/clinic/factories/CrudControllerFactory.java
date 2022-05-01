package com.clinic.factories;

import java.util.HashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractCrudController;

public class CrudControllerFactory {
    private static Map<Class<?>, AbstractCrudController<?, ?>> controllers = new HashMap<>();

    /**
     * Get a controller object which should extend 
     * @param theClass example: MedicineController.class
     * @return instance of a controller
     */
    @SuppressWarnings("unchecked")
    public static <T extends AbstractCrudController<?, ?>> T getController(Class<T> theClass) {
        if (!controllers.containsKey(theClass))
            try {
                controllers.put(theClass, theClass.getConstructor().newInstance());
            } catch (Exception e) {
                System.out.println(
                    "Exception in CrudControllerFactory.getController(Class<T> theClass): " + e.toString());
            }
        
        controllers.get(theClass).setCurrentFetchWhereClause("");
        return (T) controllers.get(theClass);
    }
}
