package daotests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

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

import data.MyLoginDAO;
import entities.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml" })
@WebAppConfiguration
@Transactional
public class MyLoginDAOTest {
	int id;

		@Autowired
		private WebApplicationContext wac;

		@Autowired
		private MyLoginDAO dao;

		@PersistenceContext
		private EntityManager em;

		@Before
		public void setUp() {
			dao = (MyLoginDAO) wac.getBean("loginDao");
		}

		@Test
		public void test_login() throws SQLException {
			String u = "JohnWaldorf";
			String p = "password";
			
			Member b = dao.checkUserPassword(u, p);
			assertEquals("John", b.getfName());
		}
		
		@Test
		public void test_true() {
			boolean pass = true;
			assertEquals(pass, true);
		}

		@After
		public void tearDown() {
			dao = null;
			em = null;
			wac = null;
		}
	
		
	}
