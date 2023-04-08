package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;
import ch05.many2many._01.anno.model.Author;

public class HQLEX002 {

	public static void main(String[] args) {
		System.out.println("本程式為模板，無法執行");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT a.authorName FROM ch05_mm1_Author a";

//		Object obj = new Object();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List<String> names = session.createQuery(hql, String.class).getResultList();

			for (String name : names) {
				System.out.println(name);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

}
