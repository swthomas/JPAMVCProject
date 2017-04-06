package data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Bill;

@Transactional
@Repository
public class BillDAOImpl implements BillDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	BillResponsibilityDAO brdao;

	@Autowired
	AccountDAO accountdao;

	@Override
	public Bill updateBill(Bill bill, Date dDate, String name, double amount){
		Bill billUpdate = em.find(Bill.class, bill.getId());

		billUpdate.setName(name);
		billUpdate.setAmount(amount);
		billUpdate.setDateDue(dDate);
		return billUpdate;
	}
		
	@Override
	public Bill updateBill(Bill bill, Date dateDue, Date datePaid, String name, double amount) {
		Bill billUpdate = em.find(Bill.class, bill.getId());

		billUpdate.setName(bill.getName());
		billUpdate.setAmount(bill.getAmount());
		billUpdate.setDateDue(dateDue);
		billUpdate.setDatePaid(datePaid);
		return billUpdate;
	}

	@Override
	public Bill addBill(Bill bill) {
		em.persist(bill);
		em.flush();
		return bill;
	}

	@Override
	public Bill getBill(int id) {
		return em.find(Bill.class, id);
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

	@Override
	public boolean deleteBill(int id) {
		try{
			Bill b = em.find(Bill.class, id);
			System.out.println(b.getName() + " ******** in delete Bill");
			if (b != null) {
				em.remove(b);
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}

		return false;
	}
	
	@Override
	public boolean deleteAdminBill(int id) {
		try{
			Bill b = em.find(Bill.class, id);
			brdao.deleteBillResponsibility(b);
			
			if (b != null) {
				em.remove(b);
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public boolean payBill(int billid, int accountid) {
		try{
			Bill b = em.find(Bill.class, billid);
			
			if (b != null) {
				b.setDatePaid(new Date());
				accountdao.setBankAccount((-b.getAmount()), accountid);
				
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}

	
}
