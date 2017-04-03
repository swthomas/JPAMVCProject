package data;

import entities.Account;

public interface AccountDAO {
	public Account getAccount(Account a);
	public Account setBankAccount(Account a);
	public Account setFrugalSum(Account a);
}
