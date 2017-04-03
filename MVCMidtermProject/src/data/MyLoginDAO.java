package data;

import java.sql.SQLException;

import entities.Member;

public interface MyLoginDAO {
	public Member checkUserPassword(String username, String password) throws SQLException;
}
