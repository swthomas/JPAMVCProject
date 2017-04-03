package data;

import entities.Member;

public interface MyLoginDAO {
	public Member checkUserPassword(String username, String password);
}
