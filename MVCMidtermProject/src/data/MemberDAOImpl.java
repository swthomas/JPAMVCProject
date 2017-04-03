package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Member;

@Transactional
@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Member createMember(Member member) {		
		Member m = new Member();
		em.persist(m);
		em.flush();
		return m;
	}

	@Override
	public Member updateMember(int id, Member member) {
		Member m = em.find(Member.class, id);
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
