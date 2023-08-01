package com.files.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductDao {

	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int saveProduct(Product product) {
	Session s = this.factory.openSession();
	Transaction tx = s.beginTransaction();
	int pid =(int)s.save(product);
	tx.commit();
	s.close();
	return pid;
	}
	public List<Product> getAllProduct(){
		Session s = this.factory.openSession();
		Query q = s.createQuery("from Product");
		List<Product> list = q.list();
		s.close();
		return list;
	}
	public List<Product> getAllProductById(int cid){
		Session s = this.factory.openSession();
		Query q = s.createQuery("from Product where category.cid=:id");
		q.setParameter("id", cid);
		List<Product> list = q.list();
		s.close();
		return list;
	}
}
