package com.todo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory emf;
    private HibernateUtil() {
    }
    //Objeto resposável por comunicação entre DAO e Persistence. Não tem construtor público
    public static EntityManagerFactory geteEntityManagerFactory() {
        if (emf == null) {
            try {
                emf = Persistence
                        .createEntityManagerFactory("TaskManager");
            } catch (Exception ex) {
                System.err.println("Initial SessionFactory creation failed."
                        + ex);
            }
        }
        return emf;
    }
}
