package com.files.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoryDao {

	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public int saveCategory(Category cat ) {
		Session s = this.factory.openSession();
		Transaction tx = s.beginTransaction();
		int cid=(int)s.save(cat);
		tx.commit();
		s.close();
		return cid;
	}
	public List<Category> getCategories(){
		Session s = this.factory.openSession();
		Query q = s.createQuery("from Category");
		List<Category> list = q.list();
		s.close();
		return list;
		
	}
	public Category getCatById(int cid) {
		Session s = this.factory.openSession();
		Category category = s.get(Category.class, cid);
		s.close();
		return category;
	}
}
