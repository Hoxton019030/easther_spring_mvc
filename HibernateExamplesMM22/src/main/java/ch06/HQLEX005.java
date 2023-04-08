package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;
import ch05.many2many._01.anno.model.Author;

public class HQLEX005 {

	public static void main(String[] args) {
		System.out.println("本程式為模板，無法執行");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM ch05_mm1_Author a WHERE a.authorId >=2";

//		Object obj = new Object();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List<Author> authors = session.createQuery(hql, Author.class).getResultList();

			for (Author a : authors) {
				System.out.println(a.getAuthorId()+","+a.getAuthorName());
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
