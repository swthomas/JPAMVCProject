package daotests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import data.IncomeDAO;
import entities.Income;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml" })
@WebAppConfiguration
@Transactional
public class IncomeDAOTest {
	
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private IncomeDAO dao;

	@PersistenceContext
	private EntityManager em;

	@Before
	public void setUp() {
		dao = (IncomeDAO)wac.getBean("incomeDao");
	}

	@After
	public void tearDown() {
		dao = null;
		em = null;
		wac = null;
	}
	
	@Test
	public void test_get_income() { // not sure if this is right
		Income income = em.find(Income.class, 1);
//		income.setId(1);
		Income inc = dao.getIncome(income);
		assertEquals(1, inc.getId());
	}
	
	@Test
	public void test_set_income() throws ParseException {
		Income inc = new Income();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		inc.setId(11);
		inc.setName("test");
		inc.setDate(date);
		inc.setAmount(20.00);
		Income i = dao.setIncome(inc);
		assertEquals("test", i.getName());
	}

}
