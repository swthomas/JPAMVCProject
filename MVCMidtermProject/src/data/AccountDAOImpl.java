package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entities.Account;
import entities.Member;

public class AccountDAOImpl implements AccountDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	MemberDAO memberdao;

	@Autowired
	FamilyDAO familydao;

	@Override
	public Account getMemberAccount(int id) {
		TypedQuery query = em.createQuery("SELECT a FROM Account a WHERE " + "a.id = :id", Account.class);

		return (Account) query.setParameter("id", id).getSingleResult();

	}

	@Override
	@Transactional
	public void setBankAccount(Double amount, int id) {
		Member m = em.find(Member.class, id);
		
		
		Double ba = m.getAccount().getBankAccount();
		ba += amount;
		m.getAccount().setBankAccount(ba);

		em.persist(m);
	}

	@Override
	@Transactional
	public void setFrugalSum(Double amount, int id) {
		Member m = em.find(Member.class, id);
		Double ba = m.getAccount().getBankAccount();
		ba -= amount;
		Double fa = m.getAccount().getFrugalSum();
		fa += amount;
		m.getAccount().setBankAccount(ba);
		m.getAccount().setFrugalSum(fa);
		
		em.persist(m);
	}
	
	@Override
	public double getFamilyFrugalTotal(int id) {
		List<Member> m = familydao.getMemberByFamily(id);
		double amount = 0;
		
		for (Member member : m) {
			amount += member.getAccount().getFrugalSum();
		}
		
		
		return amount;
	}

}
