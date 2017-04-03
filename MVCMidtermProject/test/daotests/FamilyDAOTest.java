package daotests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import data.FamilyDAO;
import entities.Family;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml" })
@WebAppConfiguration
@Transactional
public class FamilyDAOTest {
	Family family;
	int id;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FamilyDAO dao;

	@PersistenceContext
	private EntityManager em;

	@Before
	public void setUp() {
		dao = (FamilyDAO) wac.getBean("familyDao");
	}

	@Test
	public void addFamily() {
		Family fam = em.find(Family.class, 1);
		
		Family family = dao.addFamily(fam);
		assertEquals(1, family.getId());
	}
	
	@Test
	public void updateFamily() {
		Family fam = em.find(Family.class, 1);
		
		Family family = dao.updateFamily(fam);
		assertEquals(1, family.getId());
	}
	
	@Test
	public void deleteFamily() {
		Family fam = em.find(Family.class, 1);

		boolean family = dao.deleteFamily(1);
		assertEquals(true, family);
	}
	
	@Test
	public void getFamilyById() {
		Family family = dao.getFamilyById(1);
		assertEquals(1, family.getId());
	}

	@After
	public void tearDown() {
		dao = null;
		em = null;
		wac = null;
	}

}