package data;

import java.util.List;

import entities.Bill;
import entities.BillResponsibility;
import entities.Family;
import entities.Member;

public interface BillResponsibilityDAO {
	public BillResponsibility showResponsibility(int id);
	public List<BillResponsibility> createResponsibility(Bill bill, List<Member> members);
	public void deleteBillResponsibility(Bill bill);
}
