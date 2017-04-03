package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Member;

public class MyLoginDAOImpl implements MyLoginDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Member checkUserPassword(String username, String password) {
		
		String query = "SELECT m FROM Member m WHERE m.username = :username and password = :password";

		Member m  = em.createQuery(query, Member.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		
		if (m != null) {
			return m;
		}
		return null;
		
	}

}
