package com.clinic.factories;

import java.util.HashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractEntityRepository;

/**
 * A factory for getting entity repositories. This class was made to make sure
 * that there is only one entity's repository instance in the whole application
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public class EntityRepositoryFactory {
    private static Map<Class<?>, AbstractEntityRepository<?>> repositories = new HashMap<>();

    /**
     * Get a repository object which should extend 
     * <code>AbstractEntityRepository</code>.
     * @param theClass example: MedicineRepository.class
     * @return instance of <code>theClass</code>
     */
    @SuppressWarnings("unchecked")
    public static <T extends AbstractEntityRepository<?>> T getRepository(Class<T> theClass) {
        if (!repositories.containsKey(theClass))
            try {
                repositories.put(theClass, theClass.getConstructor().newInstance());
            } catch (Exception e) {
                System.out.println(
                        "Exception in EntityRepositoryFactory.getRepository(Class<T> theClass): " + e.toString());
            }
        
        return (T) repositories.get(theClass);
    }
}
