package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Family;
import entities.Member;

@Transactional
@Repository
public class FamilyDAOImpl implements FamilyDAO {

	@PersistenceContext
	private EntityManager em;

	public Family addFamily(Family family) {
		em.persist(family);
		em.flush();

		return family;
	}

	@Override
	public Family updateFamily(Family family) {
		Family f = em.find(Family.class, family.getId());
		f.setId(family.getId());
		f.setName(family.getName());
		return f;
	}

	@Override
	public boolean checkFamily(String name) {
		Family f = null;
		try {
			String query = "Select f From Family f where f.name = :name ";
			f = em.createQuery(query, Family.class).setParameter("name", name).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("catch*******************************************");
			return true;

		}
		System.out.println("*******************************************");
		return false;
	}

	@Override
	public boolean deleteFamily(int id) {
		Family f = em.find(Family.class, id);

		if (f != null) {
			em.remove(f);
			return true;
		}
		return false;
	}

	public Family getFamilyById(int id) {
		Family fam = em.find(Family.class, id);

		return fam;

	}

	@Override
	public boolean checkUser(String name) {
		Member m = null;
		try {
			String query = "Select f From Member f where f.username = :name ";
			m = em.createQuery(query, Member.class).setParameter("name", name).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("catch*******************************************");
			return true;

		}
		System.err.println("*******************************************" + m);
		
		return false;
	}

}
