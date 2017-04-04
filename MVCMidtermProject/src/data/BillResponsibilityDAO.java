package data;

import java.util.List;

import entities.BillResponsibility;
import entities.Member;

public interface BillResponsibilityDAO {
	public List<Member> showFamilyBillAndResponsibility(int id);
	public BillResponsibility createResponsibility(BillResponsibility br);
	public BillResponsibility updateResponsibility(BillResponsibility br);
	BillResponsibility showResponsibility(int id);
}
