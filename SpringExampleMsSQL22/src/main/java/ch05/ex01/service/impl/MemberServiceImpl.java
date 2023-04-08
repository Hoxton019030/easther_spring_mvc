package ch05.ex01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch05.ex00.entity.Member;
import ch05.ex00.repository.MemberRepository;
import ch05.ex00.service.MemberService;

@Service("memberServiceInMemory")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("MemberRepositoryInMemory")
	MemberRepository memberRepository;
	
	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Member findById(Long id) {
		return memberRepository.findById(id);
	}
	
	@Override
	public boolean existsByMemberId(String memberId) {
		return memberRepository.existsByMemberId(memberId);
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
	public boolean existsById(Long id) {
		return memberRepository.existsById(id);
	}

}
