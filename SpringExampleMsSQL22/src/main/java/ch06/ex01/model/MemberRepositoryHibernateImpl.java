package ch06.ex01.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch05.ex00.entity.Member;
import ch05.ex00.repository.MemberRepository;

@Repository("MemberRepositoryHibernate")
public class MemberRepositoryHibernateImpl implements MemberRepository {
	
	SessionFactory factory;
    
	@Autowired
	public MemberRepositoryHibernateImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public Member save(Member member) {
		Session session = factory.getCurrentSession();
		Long id = (Long) session.save(member);
		return session.get(Member.class, id);
	}

	@Override
	public Member findById(Long id) {
		Member member = null;
		Session session = factory.getCurrentSession();
		member = (Member) session.get(Member.class, id);
		return member;
	}

	@Override
	public boolean existsById(Long id) {
		Session session = factory.getCurrentSession();
		if (session.get(Member.class, id) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void update(Member mem) {
		Member member = null;
		Session session = factory.getCurrentSession();
		// 
		member = (Member) session.get(Member.class, mem.getId());
		member.setEmail(mem.getEmail());
		member.setExperience(mem.getExperience());
		member.setName(mem.getName());
		member.setBirthday(mem.getBirthday());
		member.setPassword(mem.getPassword());
		member.setRegisterDate(mem.getRegisterDate());
		session.update(member);
	}

	@Override
	public void deleteById(Long id) {
		Session session = factory.getCurrentSession();
		Member mem = new Member();
		mem.setId(id);
		session.delete(mem);
	}

	@Override
	public List<Member> findAll() {
		List<Member> allMembers = new ArrayList<Member>();
		Session session = factory.getCurrentSession();
		allMembers = session.createQuery("FROM Member", Member.class).list();
		return allMembers;
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		System.out.println("memberId=" + memberId);
		String queryString = "FROM Member m WHERE m.memberId = :memberId";
		List<?> list = session.createQuery(queryString)
							  .setParameter("memberId", memberId)
							  .getResultList();
		
		if (!list.isEmpty()) {
			exist = true;
		}
		return exist;
	}
}
