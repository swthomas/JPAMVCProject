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

import data.BillDAO;
import data.FamilyDAO;
import data.MemberDAO;
import entities.Bill;
import entities.Family;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class CreateController {
	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private FamilyDAO familyDao;

	@Autowired
	private BillDAO billDao;

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

		boolean check = familyDao.checkFamily(family.getId());
		if (check == true) {
			Family f = familyDao.addFamily(family);
			mv.addObject(member);
			mv.addObject("family", f);
			mv.setViewName("createfamily");
		} else {
			String badLogin = "Family already exists. \nPlease try again.";
			mv.addObject("badLogin", badLogin);
			mv.setViewName("signup");
		}
		return mv;
	}

	@RequestMapping(path = "CreateFamilyAdmin.do", method = RequestMethod.POST)
	public ModelAndView createFamilyAdmin(@ModelAttribute("sessionUser") Member member, Family family) {

		ModelAndView mv = new ModelAndView();
		Family f = familyDao.addFamily(family);
		Member m = new Member();

		if (f == null) {
			mv.setViewName("error");
		} else {
			m.setAdmin(true);
			mv.addObject(member);
			mv.addObject("family", f);
			mv.setViewName("createfamily");
		}
		return mv;
	}

	@RequestMapping(path = "CreateMember.do", method = RequestMethod.POST)
	public ModelAndView createMember(Member member, @RequestParam("familyId") int id) {
		ModelAndView mv = new ModelAndView();
		Family family = familyDao.getFamilyById(id);

		Family f = memberDao.createMembersList(member, family);
		mv.addObject(member);
		mv.addObject("f", f);
		mv.setViewName("createfamily");
		return mv;
	}

	// *********** BEGIN NEW ADD BILLS************************

	// @RequestMapping(path = "CreateMemberBillForm.do", method =
	// RequestMethod.POST)
	// public ModelAndView createMemberBillForm(@ModelAttribute("sessionUser")
	// Bill bill) {
	// ModelAndView mv = new ModelAndView();
	// mv.addObject(bill);
	// mv.setViewName("addmemberbill");
	// return mv;
	// }
	//
	// @RequestMapping(path = "CreateMemberBill.do", method =
	// RequestMethod.POST)
	// public ModelAndView createMemberBill(Bill bill, @RequestParam("memberId")
	// int id) {
	// ModelAndView mv = new ModelAndView();
	// Member member = memberDao.showMember(id);
	//
	// Member m = (Member) billDao.getMemberBills(member.getId());
	// mv.addObject(bill);
	// mv.addObject("m", m);
	// mv.setViewName("userProfile");
	// return mv;
	// }
	//
	// @RequestMapping(path = "CreateFamilyBillForm.do", method =
	// RequestMethod.POST)
	// public ModelAndView createFamilyBillForm(@ModelAttribute("sessionUser")
	// Bill bill) {
	// ModelAndView mv = new ModelAndView();
	// mv.addObject(bill);
	// mv.setViewName("addfamilybill");
	// return mv;
	// }
	//
	// @RequestMapping(path = "CreateFamilyBill.do", method =
	// RequestMethod.POST)
	// public ModelAndView createFamilyBill(Bill bill, @RequestParam("familyId")
	// int id) {
	// ModelAndView mv = new ModelAndView();
	// Family family = familyDao.getFamilyById(id);
	//
	// Family f = (Family) billDao.getFamilyBills(family.getId());
	// mv.addObject(bill);
	// mv.addObject("f", f);
	// mv.setViewName("adminProfile");
	// return mv;
	// }

	// ************ NEW ADD BILL METHOD END

	// @RequestMapping(path = "CreateMembers.do", method = RequestMethod.POST)
	// public ModelAndView createMember(@ModelAttribute("sessionUser")Member
	// member, Family family) {
	// ModelAndView mv = new ModelAndView();
	//
	// if(member == null){
	// mv.setViewName("error");
	// }
	// else{
	// Member m = memberDao.createMember(member, family);
	// mv.addObject("members", m);
	// mv.setViewName("confirmation");
	// }
	// return mv;
	// }
}
