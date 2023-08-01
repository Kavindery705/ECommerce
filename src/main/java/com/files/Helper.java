package com.files;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Helper {

	public static String get10Words(String desc) {
		String[] str = desc.split(" ");
		if(str.length>10) {
			String res ="";
			for(int i =0 ;i<10;i++) {
				res +=str[i]+" ";
			}
			return (res+"...");
		}
		else
		{
			return (desc+"...");
		}
	}
	public static Map<String,Long> getCounts(SessionFactory factory) {
		Session s = factory.openSession();
		Query q1 = s.createQuery("select count(*) from User");
		Query q2 = s.createQuery("select count(*) from Product");
		long ucount = (long) q1.list().get(0);
		long pcount = (long)q2.list().get(0);
		Map<String , Long> map = new HashMap<>();
		map.put("ucount", ucount);
		map.put("pcount", pcount);
		s.close();
		return map;
		
	}
}
