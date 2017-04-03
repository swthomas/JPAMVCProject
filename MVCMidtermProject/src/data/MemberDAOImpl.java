package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Account;
import entities.Member;

@Transactional
@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@PersistenceContext
	private EntityManager em;

	public List<Member> createMembersList(List<Member> memberList) {
		List<Member> list = new ArrayList<>();
		
		for (Member m: memberList) {
			Member member = new Member();
			member = m;
			
			Account a = new Account();
			a.setBankAccount(0.00);
			a.setFrugalSum(0.00);
			
			member.setAccount(a);
			a.setMember(m);
			
			em.persist(member);
			em.flush();
			
			list.add(member);
		}
		return list;
	}

	
	@Override
	public Member createMember(Member member) {		
		Member m = new Member();
		m = member;
		
		Account a = new Account();
		a.setBankAccount(0.00);
		a.setFrugalSum(0.00);
		
		m.setAccount(a);
		a.setMember(m);
		
		em.persist(m);
		em.flush();

		return member;
	}

	@Override
	public Member updateMember(Member member) {
		Member m = em.find(Member.class, member.getId());
		m.setUsername(member.getUsername());
		m.setPassword(member.getPassword());
		return m;
	}

	@Override
	public boolean deleteMember(int id) {
		Member m = em.find(Member.class, id);
		
		if (m != null) {
			em.remove(id);
			return true;
		}	
		return false;
	}

	@Override
	public Member showMember(int id) {
		return em.find(Member.class, id);
	}

}
