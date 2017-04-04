package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Account;
import entities.BillResponsibility;
import entities.Member;

@Transactional
@Repository
public class BillResponsibilityDAOImpl implements BillResponsibilityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Member> showFamilyBillAndResponsibility(int id) {
		List<Member> bills = null;
		try {
			String query = "SELECT m.id, m.fName, m.lName, b.id, b.name, b.amount, b.dateDue, b.datePaid, br.percent FROM Member m JOIN Family f ON m.familyId = f.id JOIN Bill b on f.id = b.familyId JOIN BillResponsibility br on b.id = br.billId WHERE m.id = :id and br.memberId = :id";
			bills = em.createQuery(query, Member.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bills;
	}

	@Override
	public BillResponsibility createResponsibility(BillResponsibility br) {
		em.persist(br);
		em.flush();
		return br;
	}

	@Override
	public BillResponsibility updateResponsibility(BillResponsibility br) {
		
		BillResponsibility respUpdate = em.find(BillResponsibility.class, br.getId());
		respUpdate.setPercent(br.getPercent());
		return respUpdate;
	}
}
