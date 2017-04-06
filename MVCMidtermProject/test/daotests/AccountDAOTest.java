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

import data.AccountDAO;
import entities.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml" })
@WebAppConfiguration
@Transactional
public class AccountDAOTest {
	Account account;
	int id;

		@Autowired
		private WebApplicationContext wac;

		@Autowired
		private AccountDAO dao;

		@PersistenceContext
		private EntityManager em;

		@Before
		public void setUp() {
			dao = (AccountDAO) wac.getBean("accountDao");
		}

		@Test
		public void getMemberAccount() {
			Account a = em.find(Account.class, 1);
			
			Account account = dao.getMemberAccount(1);
			assertEquals(1, account.getId());
		}
		

//		@Test
//		public void setBankAccount() {
//			Account account = new Account();
//			account = em.find(Account.class, 3);
////			assert(account.getBankAccount() == 300);
//			Account a = dao.setBankAccount(account);
//			assertEquals(23000, a.getBankAccount(), 0.1);
//		}
//		@Test
//		public void setFrugalSum() {
//			Account account = em.find(Account.class, 1);
//			dao.setFrugalSum(account);
//			assert(account.getFrugalSum() == 1000);
//		}


		@After
		public void tearDown() {
			dao = null;
			em = null;
			wac = null;
		}
	
		
	}


