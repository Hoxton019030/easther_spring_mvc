package lab01.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;

@Repository
public class MemberHibernateDaoImpl implements MemberDao {
	SessionFactory factory;


	@Autowired
	public MemberHibernateDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}




//	private static final String SELECT_BY_MEMBERID = "SELECT memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE memberId = ?";

	public MemberBean findByMemberId(String id) {
		MemberBean result = null;
		String hql = "FROM MemberEntity m WHERE m.memberId = :pid";
		Session session = factory.getCurrentSession();
		List<MemberBean> beans = session.createQuery(hql, MemberBean.class).setParameter("pid", id).getResultList();

		if (beans.size() > 0) {
			result = beans.get(0);
		}
		return result;
	}

//	private static final String SELECT_ALL = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01";

	public List<MemberBean> findAll() {
		String hql = "FROM MemberEntity  ";
		Session session = factory.getCurrentSession();
		List<MemberBean> result = session.createQuery(hql, MemberBean.class).getResultList();

		return result;
	}

//	private static final String INSERT = "INSERT INTO memberlab01 (memberId, password, name, phone, birthday, registerdate, picture, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		bean.setRegisterDate(ts);
		session.save(bean);

	}

//	private static final String DELETE_BY_MEMBERID = "DELETE FROM memberlab01 WHERE memberId=?";

	public void deleteByMemberId(String memberId) {
		String hql = "DELETE FROM MemberEntity m WHERE m.memberId = :pid";
		Session session = factory.getCurrentSession();
		session.createQuery(hql, MemberBean.class).setParameter("pid", memberId).executeUpdate();
		return;
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		MemberBean memberBean = findByMemberId(memberId);
		return (memberBean != null);
	}

//	private static final String SELECT_BY_ID = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE id = ?";

	@Override
	public MemberBean findById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = session.get(MemberBean.class, id);
		return memberBean;
	}

//	private static final String DELETE_BY_ID = "DELETE FROM memberlab01 WHERE id=?";

	@Override
	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		session.delete(memberBean);

	}

//	private static final String UPDATE = "UPDATE memberlab01 set name = ?,  password = ?,  phone = ?, birthday = ?,  weight = ? WHERE id = ?";

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		MemberBean member = findById(memberBean.getId());
		memberBean.setRegisterDate(member.getRegisterDate());
		session.merge(memberBean);
//		加session.evict(member)就可以用update
//		session.update(memberBean);不可以用Update因為memberbean會變成永續物件，在同一個 session 裡面的兩個物件不能有兩格相同的 oid`,可以先把一個永續物件驅逐
	}

}