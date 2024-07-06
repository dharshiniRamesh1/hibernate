package com.main;




import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bean.Student;
import com.bean.College;
import com.bean.Studentdetails;
public class Manager {

	public static void main(String[] args) {
		
		Student student1= new Student();
		student1.setS_id(1);
		student1.setName("Ram");
		student1.setAddress("chennai");
		student1.setMarks("100");
		
		
		
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure("Resource/hibernate.cfg.xml");
		SessionFactory session = cfg.buildSessionFactory();
		Session sess=session.openSession();
		Transaction trns =sess.beginTransaction();
		
		
		sess.save(student1);
		//trns.commit();
		
		
		
		College college = new College();
		college.setCaddress("Karur");
		college.setCname("VSB");
		college.setId(123);
		
		
		
		sess.save(college);
		//trns.commit();
		
		//System.out.println("Demo");
		
		
		Studentdetails st = new Studentdetails(1234,"Ram","chennai");
	

		Studentdetails st1 = new Studentdetails(1234,"rams,","chennai1");
		Studentdetails st2 = new Studentdetails(1235,"ramesh,","chennai2");
		//session.persist(st); it a void 
		//Configuration cfg = new Configuration();
		//cfg.configure("Resource/hibernate.cfg.xml");
		//SessionFactory session = cfg.buildSessionFactory();
		//Session sess=session.openSession();
		//Transaction trns =sess.beginTransaction();
		
		//sess.save(st);
		//sess.save(st1);
		//sess.save(st2);
		
		
		/*Object objData = sess.load(Studentdetails.class,new Integer(1234));
		Studentdetails std=(Studentdetails) objData;
		System.out.println(std); for select the coloum*/
		
		Object getData = sess.load(Studentdetails.class,new Integer(1));
  
   
	System.out.println(getStudentdetails.getS_id());
   	System.out.println(getStudentdetails);
   	 sess.delete(getStudentdetails);
   	// sess.update(st);
		
		
		
		
		trns.commit();
		System.out.println("Demo");


		
		
		
	
	}

}
