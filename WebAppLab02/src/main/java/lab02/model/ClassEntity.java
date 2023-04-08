package lab02.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class_table")
public class ClassEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer 	classId;
	private String 		classCode;
	private String 		className;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private Set<StudentEntity> students; 

	public ClassEntity() {
	}

	public ClassEntity(String classCode, String className) {
		this.className = className;
		this.classCode = classCode;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassEntity [classId=" + classId + ", classCode=" + classCode + ", className=" + className
				+ ", students=" + students + "]";
	}
	
}