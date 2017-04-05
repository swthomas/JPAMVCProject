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
	public Bill updateBill(Bill bill, Date dateDue, Date datePaid, String name, double amount);
	public boolean deleteBill(int id);
	Bill updateBill(Bill bill, Date dDate, String name, double amount);
	
}
