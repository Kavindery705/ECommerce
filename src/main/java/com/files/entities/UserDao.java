package com.files.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao {

	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public User getUserByemailpass(String email,String password) {
		User user = null;
		String query="from User where uemail=: e and upassword=: p";
		Session s = this.factory.openSession();
		Query q = s.createQuery(query);
		q.setParameter("e", email);
		q.setParameter("p", password);
		user = (User)q.uniqueResult();
		s.close();
		return user;
		
	}
}
