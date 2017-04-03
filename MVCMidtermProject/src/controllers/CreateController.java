//package controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import data.FamilyDAO;
//import data.MemberDAO;
//import entities.Family;
//import entities.Member;
//
//@Controller
//@SessionAttributes("user")
//public class CreateController {
//	@Autowired
//	private MemberDAO memberDao;
//	
//	@Autowired 
//	FamilyDAO familyDao;
//
//	
//	@RequestMapping(path = "CreateFamily.do", method = RequestMethod.POST)
//	public ModelAndView createFamily(String name) {
//		ModelAndView mv = new ModelAndView();
//		Family f = familyDao.createFamily(name);
//		
//		if(f == null){
//	    	mv.setViewName("error");
//	    }
//	    else{
//	    	mv.addObject("family", f);
//	    	mv.setViewName("createMembers");
//	    }
//	}
//	
//	@RequestMapping(path = "Create.do", method = RequestMethod.POST)
//	public ModelAndView createMembers(@RequestParam("family") Family f) {
//		ModelAndView mv = new ModelAndView();
//		
//		if(f == null){
//	    	mv.setViewName("error");
//	    }
//	    else{
//	    	mv.addObject("family", f);
//	    	mv.setViewName("createMembers");
//	    }
//		return mv;
//	}
//	
//	@RequestMapping(path = "Create.do", method = RequestMethod.POST)
//	public ModelAndView createMembers(List<Member> memberList) {
//		ModelAndView mv = new ModelAndView();
//		
//		if(memberList == null){
//	    	mv.setViewName("error");
//	    }
//	    else{
//	    	List<Member> members = memberDao.createMembersList(memberList);
//	    	mv.addObject("members", members);
//	    	mv.setViewName("confirmation");
//	    }
//		return mv;
//	}
//	
//	
//	
//
//}
