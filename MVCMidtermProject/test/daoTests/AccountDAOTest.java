package daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import data.AccountDAO;
import entities.Account;


public class AccountDAOTest {
	Account account;

		@Autowired
		private WebApplicationContext wac;

		@Autowired
		private AccountDAO dao;

		@PersistenceContext
		private EntityManager em;

		@Before
		public void setUp() {
			dao = (AccountDAO) wac.getBean("dao");
		}

		@Test
		public void getAccount() {
			dao.getAccount(account);
			assertNotNull(account);
		}
		
		@Test
		public void setFrugalSum() {
			dao.setFrugalSum(account);
			assert (em.find(Account.class, account) != null);
		}

//		@Test
//		public void setBankAccount() {
//			dao.setBankAccount(account);
//			account = em.find(Account.class, 3);
//			assertEquals(account.getBankAccount() == null);
//		}


		@After
		public void tearDown() {
			dao = null;
			em = null;
			wac = null;
		}
	
		
	}


