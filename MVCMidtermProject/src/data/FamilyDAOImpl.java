package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Family;

@Transactional
@Repository
public class FamilyDAOImpl implements FamilyDAO {

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
			em.remove(f);
			return true;
		}
		return false;
	}
	
	public Family getFamilyById(int id) {
		Family fam = em.find(Family.class, id);
		
		return fam;
		
	}

}
