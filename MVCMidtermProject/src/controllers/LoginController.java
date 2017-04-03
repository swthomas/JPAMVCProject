package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public ModelAndView displayLogin(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionUser", member);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("sessionUser") Member member, String username,
			String password) {
		System.out.println("****");
		ModelAndView mv = new ModelAndView();

		Member b = loginDao.checkUserPassword(username, password);

		if (b != null) {
			if (b.getAdmin() == true) {
//				model.addAttribute("sessionUser", b);
				mv.addObject("member", b);
				mv.setViewName("adminProfile");
			} else {
//				model.addAttribute("sessionUser", b);
				mv.addObject("member", b);
				mv.setViewName("profile");
			}
		} else {
			String badLogin = "Unable to find Username and/or Password combination";
//			model.addAttribute("sessionUser");
			mv.addObject("badLogin", badLogin);
			mv.setViewName("index");
		}

		return mv;
	}

//	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
//	public ModelAndView logout(@ModelAttribute("sessionUser") Model model, Member member) {
//		ModelAndView mv = new ModelAndView();
//		model.
//		
//		
//		return mv;
//	}
}
