package com.main;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bean.Student;
import com.bean.College;
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
		trns.commit();
		
		System.out.println("Demo");

	}

}
