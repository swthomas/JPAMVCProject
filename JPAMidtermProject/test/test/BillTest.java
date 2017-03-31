package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Bill;

public class BillTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("MidTerm");
		em = emf.createEntityManager();

	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		Bill bill = em.find(Bill.class, 1);
		assertEquals(1, bill.getId());

	}


}
