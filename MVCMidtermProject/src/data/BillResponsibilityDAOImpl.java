package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.BillResponsibility;
import entities.Member;

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
	public BillResponsibility createResponsibility(BillResponsibility br) {
		em.persist(br);
		em.flush();
		return br;
	}

	@Override
	public BillResponsibility updateResponsibility(BillResponsibility br) {
		
		BillResponsibility respUpdate = em.find(BillResponsibility.class, br.getId());
		respUpdate.setPercent(br.getPercent());
		return respUpdate;
	}
}
