package data;

import entities.BillResponsibility;

public interface BillResponsibilityDAO {
	public BillResponsibility showResponsibility(int id);
	public BillResponsibility createResponsibility(BillResponsibility br);
	public BillResponsibility updateResponsibility(BillResponsibility br);
}
