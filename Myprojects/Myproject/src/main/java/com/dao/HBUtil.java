package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HBUtil {
    public static StandardServiceRegistry registry = null;
    public static SessionFactory sesFactory = null;

    public static SessionFactory getSesFactory() {
        if (sesFactory == null) {
            try {
                // create registry
                registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                
                // create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                
                // create metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                
                // create sessionFactory
                sesFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sesFactory;
    }
}




