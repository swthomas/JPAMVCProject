package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.FamilyDAO;
import data.MemberDAO;
import entities.Family;

@Controller
@SessionAttributes("user")
public class CreateController {
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired FamilyDAO familyDao;

	
	@RequestMapping(path = "CreateFamily.do", method = RequestMethod.POST)
	public void createFamily() {
		ModelAndView mv = new ModelAndView();
		Family f = familyDao.createFamily();
		createMembers(f);
		
		if(colleges.size()==0){
	    	mv.setViewName("error");
	    }
	    else{
	    	mv.setViewName("home");
	    	mv.addObject("collegeList", colleges);
	    }
		
		
		
	}
	

}
