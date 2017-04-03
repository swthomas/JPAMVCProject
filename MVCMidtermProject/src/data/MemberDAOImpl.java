package data;

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

	@Override
	public Member createMember(Member member) {		
		Account a = new Account();
		a.setBankAccount(0.00);
		a.setFrugalSum(0.00);
		
		em.persist(a);
		em.flush();
		
		System.out.println(a.getId());
		member.setAccount(a);
		
		em.persist(member);
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
