package lab01.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import lab01.service.MemberService;

@Transactional
@Service
public class MemberServiceHibernateImpl implements MemberService {

	MemberDao memberDao = null;
//	SessionFactory factory;沒用到不用留

//	@Autowired // 本建構子會再次簡化
//	public MemberServiceHibernateImpl(MemberDao memberDao, SessionFactory factory) {
//		this.memberDao = memberDao;
////		this.factory = factory;
//	}
	@Autowired // 本建構子已簡化
	public MemberServiceHibernateImpl(MemberDao memberDao, SessionFactory factory) {
	this.memberDao = memberDao;
//	this.factory = factory;
}

//	@Transactional
	public MemberBean findById(Integer id) {
		MemberBean memberBean = null;
		memberBean = memberDao.findById(id);
		return memberBean;
	}

//	@Transactional
	public List<MemberBean> findAll() {
		List<MemberBean> beans = new ArrayList<>();
		beans = memberDao.findAll();
		return beans;
	}

//	@Transactional
	public void save(MemberBean bean) {
		memberDao.save(bean);
	}

//	@Transactional
	public void deleteById(Integer id) {
		memberDao.deleteById(id);

	}

//	@Transactional
	@Override
	public boolean existsByMemberId(String memberId) {
		boolean exit;
		exit = memberDao.existsByMemberId(memberId);
		return exit;

	}
//	@Transactional
	@Override
	public void update(MemberBean memberBean) {
			memberDao.update(memberBean);

	}
}