package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test1 {
	public static void main(String[] args) {
		//retrieve data
		Transaction tr = null;
		try(Session session=HBUtil.getSesFactory().openSession()){
			tr = session.beginTransaction();
			
			List<Employee> li=session.createQuery("from Employee", Employee.class).list();
			//employee[]ee=(Employee[]) li.toArray(),
			System.out.print("NAME \t  DESIGNATION \t SALARY");
			for(Employee e:li) {
			System.out.println(e.getName()+"\t" +e.getDesignation()+"\t" +e.getSalary());
			
			}
			tr.commit();
			
			
		}
		catch(Exception e) {
			if(tr != null)
				tr.rollback();
			e.printStackTrace();
		}
	}

}
