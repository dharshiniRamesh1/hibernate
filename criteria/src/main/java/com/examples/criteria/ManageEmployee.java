package com.examples.criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import java.util.*;

public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageEmployee ME = new ManageEmployee();

        /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("Zara", "Ali", 2000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 5000);
        Integer empID4 = ME.addEmployee("Mohd", "Yasee", 3000);

        /* List down all the employees */
        ME.listEmployees();

        /* Print total employee count */
        ME.countEmployee();

        /* Print total salary */
        ME.totalSalary();

        /* List employees with salary exactly 2000 */
        ME.employeesWithSpecificSalary();

        /* List employees with salary less than 2000 */
        ME.lessthan();

        /* List employees whose first name starts with 'Zara' */
        ME.firstNameStart();

        /* List employees with salary between 1000 and 2000 */
        ME.SalaryBetween();
    }

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* Method to READ all the employees having salary more than 2000 */
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction
            cr.add(Restrictions.gt("salary", 2000));
            List<Employee> employees = cr.list();

            System.out.println("Employees with salary greater than 2000:");
            for (Employee employee : employees) {
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to print total number of records */
    public void countEmployee() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // To get total row count
            cr.setProjection(Projections.rowCount());
            List<Long> rowCount = cr.list();

            System.out.println("Total Employee Count: " + rowCount.get(0));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to print sum of salaries */
    public void totalSalary() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // To get total salary
            cr.setProjection(Projections.sum("salary"));
            List<Long> totalSalary = cr.list();

            System.out.println("Total Salary: " + totalSalary.get(0));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /* Method to print employees with a salary of 2000 */
    public void employeesWithSpecificSalary() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("salary", 2000));  // Add restriction for salary

            List<Employee> results = cr.list();  // Get the list of employees

            System.out.println("Employees with salary 2000:");
            for (Employee emp : results) {
                System.out.println("Employee ID: " + emp.getId() + ", Name: " + emp.getFirstName());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to print employees with a salary less than 2000 */
    public void lessthan() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction
            cr.add(Restrictions.lt("salary", 2000));
            List<Employee> employees = cr.list();

            System.out.println("Employees with salary less than 2000:");
            for (Employee employee : employees) {
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to print employees whose first name starts with 'Zara' */
    public void firstNameStart() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction
            cr.add(Restrictions.like("firstName", "Zara%"));
            List<Employee> employees = cr.list();

            System.out.println("Employees whose first name starts with 'Zara':");
            for (Employee employee : employees) {
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to print employees with salary between 1000 and 2000 */
    public void SalaryBetween() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction
            cr.add(Restrictions.between("salary", 1000, 2000));
            List<Employee> employees = cr.list();

            System.out.println("Employees with salary between 1000 and 2000:");
            for (Employee employee : employees) {
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
