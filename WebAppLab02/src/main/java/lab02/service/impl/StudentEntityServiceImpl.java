package lab02.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lab02.dao.ClassEntityDao;
import lab02.dao.StudentEntityDao;
import lab02.model.ClassEntity;
import lab02.model.StudentEntity;
import lab02.service.StudentEntityService;
@Service
@Transactional
public class StudentEntityServiceImpl implements StudentEntityService {

	StudentEntityDao  studentEntityDao;
	ClassEntityDao  classEntityDao;
	
//	@Autowired
	public StudentEntityServiceImpl(StudentEntityDao studentEntityDao, ClassEntityDao classEntityDao) {
		super();
		this.studentEntityDao = studentEntityDao;
		this.classEntityDao = classEntityDao;
	}

	@Override
	public Object save(StudentEntity student) {
		Object obj = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			ClassEntity classEntity = classEntityDao.findByClassName(student.getClassEntity().getClassName());
			if (classEntity != null) {
				student.setClassEntity(classEntity);
			} else {
				classEntityDao.save(student.getClassEntity());
			}
			obj = studentEntityDao.save(student);
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
	public StudentEntity findById(int id) {
		StudentEntity studentEntity = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			studentEntity = studentEntityDao.findById(id);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		
		return studentEntity;
	}

	@Override
	public void update(StudentEntity student) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			studentEntityDao.update(student);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
	}

	@Override
	public void delete(int id) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			studentEntityDao.delete(id);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
	}

	@Override
	public List<StudentEntity> findAll() {
		List<StudentEntity>  studentEntities = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			studentEntities = studentEntityDao.findAll();
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return studentEntities;
	}


}
