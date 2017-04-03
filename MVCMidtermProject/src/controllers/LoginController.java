//package controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import data.MyLoginDAO;
//import entities.Family;
//import entities.Member;
//
//@Controller
//@SessionAttributes("user")
//public class LoginController {
//
//	@Autowired
//	private MyLoginDAO loginDao;
//
//	@ModelAttribute("user")
//	public Member member() {
//		return new Member();
//	}
//
//	@RequestMapping(value = "SignIn.do", method = RequestMethod.GET)
//	public ModelAndView displayLogin(@ModelAttribute("user") Member member) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		mv.addObject("user", member);
//		return mv;
//	}
//	
//	@RequestMapping(value = "checkLogin.do", method = RequestMethod.POST)
//	public ModelAndView checkLogin(@ModelAttribute("user") Member member, String username, String password) {
//		ModelAndView mv = new ModelAndView();
//		
//		boolean login = loginDao.checkUserPassword(username, password);
//		
//		if (login )
//		
//		mv.setViewName("index");
//		mv.addObject("user", member);
//		return mv;
//	}
//}
