package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.FamilyDAO;
import data.MemberDAO;
import data.MyLoginDAO;
import entities.Family;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {
	@Autowired
	private MemberDAO memberDao;

	@Autowired
	FamilyDAO familyDao;

	@Autowired
	private MyLoginDAO loginDao;

	@ModelAttribute("sessionUser")
	public Member member() {
		return new Member();
	}

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public ModelAndView displayLogin(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionUser", member);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(path = "goHome.do", method = RequestMethod.POST)
	public ModelAndView goHome(Member member, @RequestParam("familyId") int id) {
		ModelAndView mv = new ModelAndView();
		Family family = familyDao.getFamilyById(id);
		boolean check = familyDao.checkUser(member.getUsername());
		System.err.println("--------------" + family.getId());

		if (check == true) {
			Family f = memberDao.createMembersList(member, family);
			mv.addObject(member);
			mv.addObject("f", f);
			mv.setViewName("index");
		} else {
			System.err.println("in else");

			Family f = memberDao.getFamilyById(id);
			System.err.println("****************" + f.getId());
			mv.addObject("family	", f);
			mv.addObject("familyCorrection", f);
			String badLogin = "Unable to find Username and/or Password combination";
			mv.addObject("badLogin", badLogin);
			mv.setViewName("createfamily");
		}

		return mv;
	}
	
	@RequestMapping(path = "goAdminHome.do", method = RequestMethod.POST)
	public ModelAndView goAdminHome(Member member, @RequestParam("familyId") int id) {
		ModelAndView mv = new ModelAndView();
		Family family = familyDao.getFamilyById(id);
		boolean check = familyDao.checkUser(member.getUsername());
		System.err.println("--------------" + family.getId());

		if (check == true) {
			Family f = memberDao.createAdminMembersList(member, family);
			mv.addObject(member);
			mv.addObject("f", f);
			mv.setViewName("index");
		} else {
			System.err.println("in else");

			Family f = memberDao.getFamilyById(id);
			System.err.println("****************" + f.getId());
			mv.addObject("family	", f);
			mv.addObject("familyCorrection", f);
			String badLogin = "Unable to find Username and/or Password combination";
			mv.addObject("badLogin", badLogin);
			mv.setViewName("createfamily");
		}

		return mv;
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)

	public ModelAndView checkLogin(@ModelAttribute("sessionUser") Member member, String username, String password)
			throws SQLException {
		ModelAndView mv = new ModelAndView();

		Member m = loginDao.checkUserPassword(username, password);


		if (m != null) {
			mv.getModelMap().addAttribute("sessionUser", m);
			mv.addObject("member", m);

			if (m.getAdmin() == true) {
				mv.setViewName("adminProfile");
			} else {
				mv.setViewName("userProfile");
			}
		} else {
			String badLogin = "Unable to find Username and/or Password combination";
			mv.addObject("badLogin", badLogin);
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	public ModelAndView logout(@ModelAttribute("sessionUser") Member member, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.setAttribute("sessionUser", new Member());
		mv.setViewName("index");
		return mv;
	}
	
}
