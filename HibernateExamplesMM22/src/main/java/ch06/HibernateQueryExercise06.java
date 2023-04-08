package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;

public class HibernateQueryExercise06 {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT SUM(e.salary), MAX(e.salary), MIN(e.birthday), AVG(e.salary), "
				   + " count(*) FROM Employee e ";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<Object[]> emps = session.createQuery(hql, Object[].class)
				   					    .getResultList();
		   for(Object[] oa : emps) {
			   System.out.println(oa[0] + ", " + oa[1] + ", " + oa[2] + ", " + oa[3] 
					                                                  + ", " + oa[4]);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
