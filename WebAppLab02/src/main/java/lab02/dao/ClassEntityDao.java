package lab02.dao;

import java.util.List;

import lab02.model.ClassEntity;

public interface ClassEntityDao {

	ClassEntity findById(int id);

	ClassEntity findByClassName(String className);
	
	Object save(ClassEntity classEntity);

	List<ClassEntity> findAll();
}
