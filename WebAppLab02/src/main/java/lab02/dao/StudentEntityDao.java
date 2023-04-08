package lab02.dao;

import java.util.List;

import lab02.model.StudentEntity;

public interface StudentEntityDao {

	// 新增一筆StudentEntity物件到資料庫
	Object save(StudentEntity studentEntity);

	StudentEntity findById(int id);
	
	// 更新紀錄
	void update(StudentEntity studentEntity);

	// 刪除紀錄
	void delete(int id);

	// 查詢所有紀錄
	List<StudentEntity> findAll();

}