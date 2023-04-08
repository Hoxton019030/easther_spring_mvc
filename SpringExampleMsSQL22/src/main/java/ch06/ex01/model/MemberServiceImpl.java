package ch06.ex01.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch05.ex00.entity.Member;
import ch05.ex00.repository.MemberRepository;
import ch05.ex00.service.MemberService;
@Transactional
@Service("memberServiceHibernate")
public class MemberServiceImpl implements MemberService {
 
	@Autowired
	@Qualifier("MemberRepositoryHibernate")//有兩個 dao所以要指名id
	MemberRepository memberRepository;

	@Override
	public boolean existsById(Long id) {
		return memberRepository.existsById(id);
	}
	
	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Member findById(Long id) {
		return memberRepository.findById(id);
	}
	
	@Override
	public void update(Member member) {
		memberRepository.update(member);
	}

	@Override
	public void deleteById(Long id) {
		memberRepository.deleteById(id);		
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		return memberRepository.existsByMemberId(memberId);
	}

}
