package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Bill;
import entities.BillResponsibility;
import entities.Member;

@Transactional
@Repository
public class BillResponsibilityDAOImpl implements BillResponsibilityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public BillResponsibility showResponsibility(int id) {
		return em.find(BillResponsibility.class, id);
	}

	@Override
	public List<BillResponsibility> createResponsibility(Bill bill, List<Member> members) {
		List<BillResponsibility> responsibilityList = new ArrayList<>();
		
		for (Member m: members){
		BillResponsibility br = new BillResponsibility();
		br.setBill(bill);
		br.setMember(m);
		br.setPercent(50);
		em.persist(br);
		em.flush();
		responsibilityList.add(br);
		}
		return responsibilityList;
	}
}
