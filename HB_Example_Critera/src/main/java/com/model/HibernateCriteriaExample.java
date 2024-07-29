package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateCriteriaExample {
	public static void main(String[]args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		//Get all employees
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> empList = criteria.list();
		for(Employee emp : empList) {
			System.out.println("ID="+emp.getId()+emp.getName()+emp.getSalary());
		}
		//pagination example
		empList = session.createCriteria(Employee.class).addOrder(Order.desc("id")).setFirstResult(0).setMaxResults(2).list();
	for(Employee emp4 : empList) {
		System.out.println("Paginated Employees::"+emp4.getId()+emp4.getName());
	}
	
	//projections example
	Criteria c = session.createCriteria(Employee.class);
	c.setProjection(Projections.rowCount());
	empList=c.add(Restrictions.like("name", "%m%")).list();
	System.out.println("Number of employee with 'm' in name="+empList.getFirst());
	//using projections for sum, min,max, aggregation functions
	Criteria d= session.createCriteria(Employee.class);
	empList=d.setProjection(Projections.sum("salary")).list();
			System.out.println("Sum of Salaries=" +empList.getFirst());
	//rollback transaction to avoid messing test data
			tx.commit();
	
	}

}
