package com.clinic;

import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryFactory {
    private static Map<Class<?>, AbstractEntityRepository<?>> repositories = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends AbstractEntityRepository<?>> T getRepository(Class<T> theClass) {
        if (!repositories.containsKey(theClass))
            try {
                repositories.put(theClass, theClass.getConstructor().newInstance());
                System.out.println("Created " + theClass.getName() + " instance");
            } catch (Exception e) {
                System.out.println(
                        "Exception in EntityRepositoryFactory.getRepository(Class<T> theClass): " + e.toString());
            }
        
        return (T) repositories.get(theClass);
    }
}
