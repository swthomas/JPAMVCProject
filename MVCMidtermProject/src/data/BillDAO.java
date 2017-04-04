package data;

import java.util.Date;
import java.util.List;

import entities.Bill;

public interface BillDAO {
	public Bill addBill(Bill bill);
	public List<Bill> getFamilyBills(int id);
	public List<Bill> getMemberBills(int id);
//	add member bill?
//	add family bill?
	public Bill getBill(int id);
	public Bill updateBill(Bill bill, Date dateDue, Date datePaid);
	public boolean deleteBill(int id);
	
}
