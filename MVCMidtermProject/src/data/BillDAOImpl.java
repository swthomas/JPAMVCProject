package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Bill;

@Transactional
@Repository
public class BillDAOImpl implements BillDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Bill updateBill(Bill bill) {
		Bill billUpdate = em.find(Bill.class, bill.getId());

		billUpdate.setName(bill.getName());
		billUpdate.setAmount(bill.getAmount());
		billUpdate.setDateDue(bill.getDateDue());
		billUpdate.setDatePaid(bill.getDatePaid());
		billUpdate.setPaid(bill.isPaid());

		return billUpdate;
	}

	@Override
	public Bill addBill(Bill bill) {
		em.persist(bill);
		em.flush();
		return bill;
	}

	@Override
	public List<Bill> getFamilyBills(int id) {
		TypedQuery<Bill> query = em.createQuery("SELECT b FROM Bill b WHERE b.family.id = :id", Bill.class);
		
		return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<Bill> getMemberBills(int id) {
		TypedQuery<Bill> query = em.createQuery("SELECT b FROM Bill b WHERE b.member.id = :id", Bill.class);
		
		return query.setParameter("id", id).getResultList();
	}

}
