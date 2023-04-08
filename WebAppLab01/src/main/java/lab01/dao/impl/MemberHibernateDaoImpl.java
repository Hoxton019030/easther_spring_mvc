package lab01.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import lab01.utils.HibernateUtils;

public class MemberHibernateDaoImpl implements MemberDao {

	SessionFactory factory;
	
	public MemberHibernateDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

//	private static final String SELECT_BY_MEMBERID = "SELECT memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE memberId = ?";

	public MemberBean findByMemberId(String id) {
		
//		Class<?> c1 = MemberBean.class;
//		Class<?> c2 = int.class;
//		Class<?> c3 = Integer.class;
		
		MemberBean result = null;
		String hql = "FROM MemberEntity m WHERE m.memberId = :pid";
		Session session = factory.getCurrentSession();
		List<MemberBean> beans = session.createQuery(hql, MemberBean.class)
				                        .setParameter("pid", id)
				                        .getResultList();
		if (beans.size() > 0) {
			result = beans.get(0); 
		}
		return result;
	}

//	private static final String SELECT_ALL = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01";

	public List<MemberBean> findAll() {
		String hql = "FROM MemberEntity";
		Session session = factory.getCurrentSession();
		List<MemberBean> result = session.createQuery(hql, MemberBean.class)
				                         .getResultList();
		
		return result;
	}

//	private static final String INSERT = "INSERT INTO memberlab01 (memberId, password, name, phone, birthday, registerdate, picture, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		bean.setRegisterDate(ts);
		session.save(bean);
	}

	private static final String DELETE_BY_MEMBERID = "DELETE FROM memberlab01 WHERE memberId=?";

	public void deleteByMemberId(String memberId) {
		
		String hql = "DELETE FROM MemberEntity m WHERE m.memberId = :mid";
		Session session = factory.getCurrentSession();
		session.createQuery(hql)
		       .setParameter("mid", memberId)
		       .executeUpdate();
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

	@Override
	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		session.delete(memberBean);
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		MemberBean member = findById(memberBean.getId());
		memberBean.setRegisterDate(member.getRegisterDate());
		// ....加一個敘述，使得 session.update(memberBean); 不會盪
		session.update(memberBean);   	// 會當掉
		//session.merge(memberBean);		// 棒
	}

}