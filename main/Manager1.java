package com.main;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.dev1.Product;

public class Manager1 {
	public static void main(String[]args) {
		AnnotationConfiguration acfg= new AnnotationConfiguration();
		acfg.configure("Resource/hibernate.cfg.xml");
		SessionFactory sf = acfg.buildSessionFactory();
		Session session =sf.openSession();
		Transaction trns =session.beginTransaction(); 
		System.out.println("Done");
		
		Product product = new Product();
		product.setP_id(1);
		product.setP_name("Ram");
		product.setQty(1);
		
		session.save(product);
		trns.commit();
		
	}

}
