package lab02.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import lab02.dao.StudentEntityDao;
import lab02.model.StudentEntity;
@Repository
public class StudentEntityDaoImpl implements StudentEntityDao {

	SessionFactory factory;
	
//	@Autowired
	public StudentEntityDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public Object save(StudentEntity studentEntity) {
		Session session = factory.getCurrentSession();
		session.save(studentEntity);
		return findById(studentEntity.getId());
	}

	@Override
	public StudentEntity findById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(StudentEntity.class, id);
	}

	@Override
	public void update(StudentEntity studentEntity) {
		Session session = factory.getCurrentSession();
		session.update(studentEntity);
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM StudentEntity WHERE id = :id";
		session.createQuery(hql)
		       .setParameter("id", id)
        	   .executeUpdate();
	}

	@Override
	public List<StudentEntity> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM StudentEntity";
		List<StudentEntity> students = session.createQuery(hql, StudentEntity.class)
				                                     .getResultList();
		return students;
	}

}
