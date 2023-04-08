package lab02.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import lab02.dao.ClassEntityDao;
import lab02.model.ClassEntity;
@Repository
public class ClassEntityDaoImpl implements ClassEntityDao {

	SessionFactory  factory;
	
//	@Autowired
	public ClassEntityDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public ClassEntity findById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(ClassEntity.class, id);
	}

	@Override
	public ClassEntity findByClassName(String className) {
		Session session = factory.getCurrentSession();
		String  hql = "FROM ClassEntity c WHERE c.className = :className"; 
		List<ClassEntity> classEntities = session.createQuery(hql, ClassEntity.class)
				                           .setParameter("className", className)
				                           .getResultList();
		if (classEntities.size() > 0) {
			return classEntities.get(0);
		}  else {
			return null;
		}
	}

	@Override
	public Object save(ClassEntity classEntity) {
		Session session = factory.getCurrentSession();
		session.save(classEntity);
		return findById(classEntity.getClassId());
	}

	@Override
	public List<ClassEntity> findAll() {
		Session session = factory.getCurrentSession();
		String  hql = "FROM ClassEntity"; 
		List<ClassEntity> classEntities = session.createQuery(hql, ClassEntity.class)
				                                 .getResultList();
		return classEntities;
	}

}
