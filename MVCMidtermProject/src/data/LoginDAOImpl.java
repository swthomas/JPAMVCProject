package data;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean checkUserPassword(String username, String password) {
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public boolean checkUserPassword(String username, String password) {
			TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.username = :username", Member.class);
			Member m = query.setParameter("username", username).getSingleResult();
			
			if (m.getPassword() == password) {
				return true;
			}
			return false;
		}

	}	}

}
