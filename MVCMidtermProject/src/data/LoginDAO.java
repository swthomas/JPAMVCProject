package data;
import entities.Member;

public interface LoginDAO {
	public boolean checkUserPassword(String username, String password);
}
