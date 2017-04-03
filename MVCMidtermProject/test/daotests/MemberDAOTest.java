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

import data.MemberDAO;
import entities.Family;
import entities.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml" })
@WebAppConfiguration
@Transactional
public class MemberDAOTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MemberDAO dao;

	@PersistenceContext
	private EntityManager em;

	@Before
	public void setUp() {
		dao = (MemberDAO) wac.getBean("memberDao");
	}

	@After
	public void tearDown() {
		dao = null;
		em = null;
		wac = null;
	}

	@Test
	public void test_update_member() { 
		Member m = em.find(Member.class, 1);
		m.setUsername("Brian");
		m.setPassword("password1");
		assertEquals("Brian", dao.updateMember(m).getUsername());
	}
	
	@Test
//	public void test_create_new_member() {
//		Member m = new Member();
//
//		Family f = em.find(Family.class, 1);
//		
//		m.setFamily(f);
//		m.setfName("John");
//		m.setlName("Roxstart");
//		m.setUsername("testUserName");
//		m.setPassword("johnJohnson");
//		m.setAdmin(true);
//		
//		Member member = dao.createMember(m);
//		assertEquals("Roxstart", em.find(Member.class, member.getId()).getlName());	
//	}
	
	@Test
	public void test_show_member() {
		Member m = dao.showMember(1);
		assertEquals("John", m.getfName());
	}
	
//	@Test
//	public void test_delete_member() {
//		em.remove(em.find(Member.class, ***));
//		assertEquals(null, em.find(Member.class, ***));
//	}

	@Test
	public void test_true() {
		boolean pass = true;
		assertEquals(pass, true);
	}
}
