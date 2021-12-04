package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SingletonEntityManager {
    private static EntityManager entityManager= Persistence
            .createEntityManagerFactory("football")
            .createEntityManager();
    public static EntityManager getEntityManager(){
        return entityManager;
    }
    public static void close(){
        entityManager.close();
    }
}
