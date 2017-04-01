package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.BillResponsibility;

@Transactional
@Repository
public class BillResponsibilityDAOImpl implements BillResponsibilityDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public BillResponsibility showResponsibility(int id) {
		return em.find(BillResponsibility.class, id);
	}

	@Override
	public BillResponsibility updateResponsibility(int id, BillResponsibility br) {
		BillResponsibility resp = em.find(BillResponsibility.class, id);
		resp.setPercent(br.getPercent());
		return null;
	}

	@Override
	public BillResponsibility createResponsibility(BillResponsibility br) {
		em.persist(br);
		return null;
	}

}
