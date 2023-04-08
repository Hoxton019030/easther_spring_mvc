package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;
import ch05.many2many._01.anno.model.Author;

public class HQLEX008 {

	public static void main(String[] args) {
		System.out.println("本程式為模板，無法執行");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT SUM(a.authorId), MAX(a.authorId), MIN(a.authorId) FROM ch05_mm1_Author a";

//		Object obj = new Object();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List<Object[]> data = session.createQuery(hql, Object[].class).getResultList();

			for (Object[] a :data) {
				System.out.println(a[0]+","+a[1] +"," +a[2]);
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
