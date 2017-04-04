package controllers;

import java.util.ArrayList;
import java.util.List;

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
import entities.Family;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class CreateController {
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired 
	FamilyDAO familyDao;

	@RequestMapping(path = "CreateFamilyForm.do", method = RequestMethod.POST)
	public ModelAndView goToCreateFamilyForm(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(member);
		mv.setViewName("signup");
		return mv;	
	}
	
	@RequestMapping(path = "CreateFamily.do", method = RequestMethod.POST)
	public ModelAndView createFamily(@ModelAttribute("sessionUser") Member member, Family family) {

		ModelAndView mv = new ModelAndView();
		Family f = familyDao.addFamily(family);
		
		if(f == null){
	    	mv.setViewName("error");
	    }
	    else{
	    	mv.addObject(member);
	    	mv.addObject("family", f);
	    	mv.setViewName("createfamily");
	    }
		return mv;
	}
	
	
	
	@RequestMapping(path = "CreateMember.do", method = RequestMethod.POST)
	public ModelAndView createMember(Member member, @RequestParam("familyId") int id) {
		ModelAndView mv = new ModelAndView();
		System.err.println("_________" + member + "___________");
		System.err.println("*************" + id + "**********");
		Family family = familyDao.getFamilyById(id);

	    	Family f = memberDao.createMembersList(member, family);
	    	mv.addObject(member);
	    	mv.addObject("family", f);
	    	mv.setViewName("createfamily");
		return mv;
	}
	
//	@RequestMapping(path = "CreateMembers.do", method = RequestMethod.POST)
//	public ModelAndView createMember(@ModelAttribute("sessionUser")Member member, Family family) {
//		ModelAndView mv = new ModelAndView();
//		
//		if(member == null){
//	    	mv.setViewName("error");
//	    }
//	    else{
//	    	Member m = memberDao.createMember(member, family);
//	    	mv.addObject("members", m);
//	    	mv.setViewName("confirmation");
//	    }
//		return mv;
//	}
}
