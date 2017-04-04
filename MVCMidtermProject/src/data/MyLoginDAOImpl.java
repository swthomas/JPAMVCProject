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
			String query = "SELECT m FROM Member m WHERE m.username = :username AND m.password = :password";
			m  = em.createQuery(query, Member.class).setParameter("username", username).setParameter("password", password).getSingleResult();
			
			if (m != null) {
				m = em.createQuery("SELECT m FROM Member m JOIN FETCH m.bills WHERE m.id = :id", Member.class).setParameter("id", m.getId()).getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;		
	}
}
