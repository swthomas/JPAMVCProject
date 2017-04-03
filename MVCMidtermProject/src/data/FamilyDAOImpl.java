package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
<<<<<<< HEAD

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e

import entities.Family;

@Transactional
@Repository
public class FamilyDAOImpl implements FamilyDAO {
<<<<<<< HEAD

	@PersistenceContext
	private EntityManager em;

	public Family addFamily(Family family) {
		em.persist(family);
		
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
	public boolean deleteFamily(int id) {
		Family f = em.find(Family.class, id);

		if (f != null) {
			em.remove(id);
			return true;
		}
		return false;
	}
	
	public Family getFamilyById(int id) {
		Family fam = em.find(Family.class, id);
		
		return fam;
		
	}
=======

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
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e

		if (fam != null) {
			em.remove(f.getId());
			return true;
		}
		return false;
	}
}
