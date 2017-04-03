package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Family;

public class FamilyDAOImpl implements FamilyDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Family createFamily(Family newFam) {

		Family f = new Family();
		f = newFam;
		em.persist(f);
		em.flush();

		return f;
	}

	@Override
	public Family updateFamily(Family fam) {

		Family f = em.find(Family.class, fam.getId());
		f.setName(fam.getName());
		return fam;
	}

	@Override
	public boolean deleteFamily(Family fam) {
		Family f = em.find(Family.class, fam.getId());

		if (fam != null) {
			em.remove(f.getId());
			return true;
		}
		return false;
	}
}
