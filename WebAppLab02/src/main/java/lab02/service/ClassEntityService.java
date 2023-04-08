package lab02.service;

import java.util.List;

import lab02.model.ClassEntity;

public interface ClassEntityService {

	ClassEntity findById(int id);

	ClassEntity findByClassName(String className);
	
	Object save(ClassEntity classEntity);

	List<ClassEntity> findAll();
}
