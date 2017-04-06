package data;

import entities.Account;

public interface AccountDAO {
	public Account getMemberAccount(int id);
	public void setBankAccount(Double amount, int id);
	public void setFrugalSum(Double amount, int id);
	public double getFamilyFrugalTotal(int id);
}
