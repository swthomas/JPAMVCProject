package data;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Member;

public class MyLoginDAOImpl implements MyLoginDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Member checkUserPassword(String username, String password) throws SQLException{
		Member m = null;
		
		
		try {
			String query = "SELECT m FROM Member m JOIN FETCH m.bills  JOIN FETCH m.billResponsibilities WHERE m.username = :username and password = :password";
			m  = em.createQuery(query, Member.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (m != null) {
			return m;
		}
		return null;
		
	}

}
