package data;

import java.util.List;

import entities.Bill;

public interface BillDAO {
	public Bill updateBill(Bill bill);
	public Bill addBill(Bill bill);
	public List<Bill> getFamilyBills(int id);
	public List<Bill> getUserBills(int id);
	
}
