package ch05.ex01.repository.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch05.ex00.entity.Member;
import ch05.ex00.listener.GlobalService;
import ch05.ex00.repository.MemberRepository;

@Repository("MemberRepositoryInMemory")
public class MemberRepositoryInMemory implements MemberRepository {

	@Override
	public Member save(Member member) {
		if (existsById(member.getId())) {
			throw new IllegalStateException("Member已存在: Id=" + member.getId());
		}
		GlobalService.getMembers().add(member);
		return member;
	}

	@Override
	public Member findById(Long id) {
		List<Member> members = GlobalService.getMembers();
		for(Member member : members) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		List<Member> members = GlobalService.getMembers();
		for(Member member : members) {
			if (member.getMemberId().equals(memberId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		List<Member> members = GlobalService.getMembers();
		for(Member member : members) {
			if (member.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Member member) {
		List<Member> members = GlobalService.getMembers();
		for(Member mem : members) {
			if (mem.getId().equals(member.getId())) {
				mem.setBirthday(member.getBirthday());
				mem.setEmail(member.getEmail());
				mem.setExperience(member.getExperience());
				mem.setName(member.getName());
				mem.setPassword(member.getPassword());
			}
		}
//		if (!existsById(member.getId())) {
//			throw new IllegalStateException("Member不存在: Id=" + member.getId());
//		}
	}

	@Override
	public void deleteById(Long id) {
		List<Member> members = GlobalService.getMembers();
		Iterator<Member> it = members.iterator();
		while (it.hasNext()) {
			Member member = it.next();
			if (member.getId().equals(id)) {
				it.remove();
			}
		}
	}

	@Override
	public List<Member> findAll() {
		return GlobalService.getMembers();
	}
}