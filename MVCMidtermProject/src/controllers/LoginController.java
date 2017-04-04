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

import data.MyLoginDAO;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {

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
	
	@RequestMapping(path = "goHome.do", method = RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("sessionUser") Member member, String username,
			String password) throws SQLException {
		ModelAndView mv = new ModelAndView();
		System.out.println(username);
		System.out.println(password);
		Member m = loginDao.checkUserPassword(username, password);

		
		if (m != null) {
			System.out.println("**************************************");
			System.out.println(m.getFamily().getBills().size());
			
			if (m.getAdmin() == true) {
				mv.addObject("member", m);
				mv.setViewName("adminProfile");
			} else {
				mv.addObject("member", m);
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
