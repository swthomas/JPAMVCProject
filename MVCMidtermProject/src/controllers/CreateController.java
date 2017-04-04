package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.FamilyDAO;
import data.MemberDAO;
import entities.Family;
import entities.Member;

@Controller
@SessionAttributes("user")
public class CreateController {
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired 
	FamilyDAO familyDao;

	
	@RequestMapping(path = "CreateFamily.do", method = RequestMethod.POST)
	public ModelAndView createFamily(Family family) {
		ModelAndView mv = new ModelAndView();
		Family f = familyDao.addFamily(family);
		
		if(f == null){
	    	mv.setViewName("error");
	    }
	    else{
	    	mv.addObject("family", f);
	    	mv.setViewName("createMembers");
	    }
		return mv;
	}
	
	
	@RequestMapping(path = "CreateFamilyForm.do", method = RequestMethod.POST)
	public ModelAndView goToCreateFamilyForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
		
	}
	@RequestMapping(path = "CreateMembers.do", method = RequestMethod.POST)
	public ModelAndView createMembers(Family family, List<Member> memberList) {
		ModelAndView mv = new ModelAndView();
		System.out.println(family);
		
		if(memberList == null){
	    	mv.setViewName("error");
	    }
	    else{
	    	List<Member> members = memberDao.createMembersList(memberList, family);
	    	mv.addObject("members", members);
	    	mv.setViewName("confirmation");
	    }
		return mv;
	}
}
