package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
		System.out.println(family.getId());
		boolean check = familyDao.checkFamily(family.getName());
		System.out.println(check + "******************************");
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


	@RequestMapping(path = "AddFamilyBillForm.do", method = RequestMethod.POST)
	public ModelAndView addFamilyBillForm(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		Family f = memberDao.showMember(member.getId()).getFamily();
		Member m1 = memberDao.showMember(id)
		mv.addObject("family", f);
		mv.setViewName("addfamilybill");

		return mv;
	}
	
	@RequestMapping(path = "AddBillForm.do", method = RequestMethod.POST)
	public ModelAndView addMemberBillForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addnewbill");

		return mv;
	}

	@RequestMapping(path = "CreateFamilyBill.do", method = RequestMethod.POST)
	public ModelAndView addFamilyBill(HttpSession session,
			@ModelAttribute("sessionUser") Member member,
			@RequestParam("familybillid") Integer familyId,
			@RequestParam("billname") String billname,
			@RequestParam("amount") double amount,
			@RequestParam("dateDue") String dueDate
			) throws ParseException {
		Bill b = new Bill();
		Family f = familyDao.getFamilyById(familyId);
		
		b.setName(billname);
		b.setFamily(f);
		b.setAmount(amount);
		b.setMember(member);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dDate = format.parse(dueDate);
		b.setDateDue(dDate);
		
		ModelAndView mv = new ModelAndView();
		billDao.addBill(b);
		
		Member m = memberDao.showMember(member.getId());
		
		mv.addObject(m);	
		mv.setViewName("adminProfile");
		
		return mv;
	}
	
	@RequestMapping(path = "CreateBill.do", method = RequestMethod.POST)
	public ModelAndView addBill(HttpSession session,
			@ModelAttribute("sessionUser") Member member,
			@RequestParam("billname") String billname,
			@RequestParam("amount") double amount,
			@RequestParam("dateDue") String dueDate
			) throws ParseException {
		Bill b = new Bill();
		b.setName(billname);
		b.setAmount(amount);
		b.setMember(member);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dDate = format.parse(dueDate);
		b.setDateDue(dDate);
		
		ModelAndView mv = new ModelAndView();
		billDao.addBill(b);
		
		Member m = memberDao.showMember(member.getId());
		
		mv.addObject(m);
		
		if (m.getAdmin() == true){
			mv.setViewName("adminProfile");
		}
		else {
			mv.setViewName("userProfile");
		}
		
		return mv;
	}
}
