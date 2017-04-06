package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Account;
import entities.Bill;
import entities.Family;
import entities.Member;

@Transactional
@Repository
public class MemberDAOImpl implements MemberDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Family createMembersList(Member member, Family family) {
		List<Bill> bills = new ArrayList<>();
		member.setBills(bills);
		member.setFamily(family);
		member.setPassword("password");
		member.setAdmin(false);
		em.persist(member);
		Account a = new Account();
		a.setBankAccount(0.00);
		a.setFrugalSum(0.00);
		a.setMember(member);

		em.persist(a);
		em.flush();

		return family;
	}
	
	@Override
	public Family createAdminMembersList(Member member, Family family) {
		List<Bill> bills = new ArrayList<>();
		member.setBills(bills);
		member.setFamily(family);
		member.setPassword("password");
		member.setAdmin(true);
		
		
		em.persist(member);
		Account a = new Account();
		a.setBankAccount(0.00);
		a.setFrugalSum(0.00);
		a.setMember(member);
		em.persist(a);
		em.flush();


		return family;
	}

	@Override
	public Member createMember(Member member, Family family) {
		List<Bill> bills = new ArrayList<>();
		member.setBills(bills);
		member.setFamily(family);
		member.setPassword("password");
		member.setAdmin(false);
		em.persist(member);
		Account a = new Account();
		a.setBankAccount(0.00);
		a.setFrugalSum(0.00);
		a.setMember(member);
		em.persist(a);
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
		Member m = null;
		try {
			String q = "SELECT m FROM Member m JOIN FETCH m.bills WHERE m.id = :id";
			m = em.createQuery(q, Member.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			m = em.find(Member.class, id);
			m.setBills(new ArrayList<>());
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Member> getFamilyMembers(int id) {
		List<Member> m = null;
		String q = "SELECT m FROM Member m WHERE m.family.id = :id";
		m = em.createQuery(q, Member.class).setParameter("id", id).getResultList();
		return m;
	}

	@Override
	public Family getFamilyById(int id) {

		return em.find(Family.class, id);
	}

}
