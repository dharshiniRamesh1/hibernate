package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ka", "Managers", 67000);
        Employee e2 = new Employee("Sri", "Clerks", 50000);

        Transaction tr = null;
        try (Session session = HBUtil.getSesFactory().openSession()) {
            tr = session.beginTransaction();
            session.persist(e1);
            session.persist(e2);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }
}






