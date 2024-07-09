package com.projects12.pro;

import java.util.Collection;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import com.projects12.bean.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfiguration cfg= new AnnotationConfiguration();
    	cfg.configure("./Resource/hibernate.cfg.xml");
    	SessionFactory sf=cfg.buildSessionFactory();
    	Session session =sf.openSession();
    	Transaction tnx=session.beginTransaction();
    	//Product pro1 = new Product();
    	
    	/*pro1.setP_id(4);
    	pro1.setP_Name("ramesh");
    	pro1.setPrice(1000);
    	
    	session.save(pro1);
    	
    	/*Query query=session.createQuery("from Product");
    	List list=query.list();
    	list.stream().forEach(temp -> System.out.println(temp));
    	/*Query query1=session.createQuery("delete from Product p where p.P_Name=:ref");
    	query1.setParameter("ref", "ramesh");
    	System.out.print(query1);
    	int i =query1.executeUpdate();
    	
    	
    	Query query2=session.createQuery("update Product p set p.P_id=123 where p.P_id=13");
    	
    	////query2.setParameter("ref1", "Ramesh");
    	//query2.setParameter("ref2", "13");
    	
    	int count=query2.executeUpdate();
    	System.out.println(count +"Updated");*/
    	
    	
    	
    	 Query query=session.createQuery("select emp from Employee emp");
    	 List<Employee>list1=query.list();
    	
		list1.stream().forEach(e->{
    		 System.out.println(e.getNAME()+", " +e.getEmpDetails().getAddress()+", "  +e.getEmpDetails().getGender()+", " +e.getEmpDetails().getBankaccount()+", " +e.getEmpDetails().getYearsofservice());
		});
		
		
		Query q3=session.createQuery("Select emp from Employee emp");
		List<Employee> emplist=q3.list();
		emplist.stream().forEach(e->{
			System.out.println(e);
			System.out.println(e.getEmpAssisgnmentList().size());
			e.getEmpAssisgnmentList().stream().forEach(temp->System.out.println("Projects "+temp.getName()+", "+temp.getOwner()));
		System.out.println("------------");
		
		
		});
		
	
		
		
  
    	 
    	/* list1.stream().forEach(temp ->
    	 {
    		 System.out.println(temp.getNAME());
    		 temp.getAssestmgnt().stream().forEach(temp1 -> 
    		 System.out.print(temp1.getASSET_NAME()+", "));
    		 System.out.println();
    		 System.out.println("------------------------");
    	 });*/
    /*	 
    	list1.stream().forEach(e->{
    		 System.out.println(e.getNAME() +", "+e.getSALARY()+", " +e.getDEPARTMENT());
    	 
    	 e.getAssestmgnt().stream().forEach(data-> System.out.println(data.getAm_ID()+", " +data.getASSET_NAME()+", " +getVendor()));
    	 });
    	 
    	/* Assestmgnt ast=new Assestmgnt();
    	
    	 ast.setASSET_NAME("Ram");
    	 ast.setEMP_ID(123);
    	 ast.setVANDAR("vandar");
    	 
    	 session.save(ast);
    	 
    	 
    	 */
    	// System.out.println(list1);
    	// int i =query.execute();
    	 
    	// tnx.commit();
    	 
    	 System.out.println("Demo");
    }

	private static long getVendor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
