package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import ch00.HibernateUtils;
import ch05.many2many._01.anno.model.Author;

public class HQLEX001 {

	public static void main(String[] args) {
		System.out.println("本程式為模板，無法執行");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM ch05_mm1_Author";
		
//		Object obj = new Object();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		List<Author> auts = session.createQuery(hql,Author.class).getResultList();

		   tx.commit();
		   System.out.println(auts);
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
