package lab02.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lab02.dao.ClassEntityDao;
import lab02.model.ClassEntity;
import lab02.service.ClassEntityService;
@Service
@Transactional
public class ClassEntityServiceImpl implements ClassEntityService {

	ClassEntityDao  classEntityDao;
//	SessionFactory  factory;
	
//	@Autowired
	public ClassEntityServiceImpl(ClassEntityDao classEntityDao) {
		super();
		this.classEntityDao = classEntityDao;
	}

	@Override
	public ClassEntity findById(int id) {
		ClassEntity classEntity = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			classEntity = classEntityDao.findById(id);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return classEntity;
	}


	@Override
	public ClassEntity findByClassName(String className) {
		ClassEntity classEntity = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
		    classEntity = classEntityDao.findByClassName(className);
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return classEntity;
	}

	@Override
	public Object save(ClassEntity classEntity) {
		Object obj = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			obj = classEntityDao.save(classEntity);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return obj;
	}

	@Override
	public List<ClassEntity> findAll() {
		List<ClassEntity>  classEntities = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
		    classEntities = classEntityDao.findAll();
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return classEntities;
	}
}
