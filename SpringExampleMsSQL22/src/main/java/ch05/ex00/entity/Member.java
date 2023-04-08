package ch05.ex00.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SpringMember")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String memberId;
	String password;
	String name;
	String email;
	Date birthday;
	Timestamp registerDate;
	Integer experience;

	public Member(Long id, String memberId, String password, String name, String email, Date birthday,
			Timestamp registerDate, Integer experience) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.registerDate = registerDate;
		this.experience = experience;
	}

	public Member() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberId=" + memberId + ", password=" + password + ", name=" + name + ", email="
				+ email + ", birthday=" + birthday + ", registerDate=" + registerDate + ", experience=" + experience
				+ "]";
	}

}