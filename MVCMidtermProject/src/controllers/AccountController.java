package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.AccountDAO;
import data.BillDAO;
import data.MemberDAO;
import entities.Bill;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class AccountController {
	
	@Autowired
	AccountDAO accountdao;
	
	@Autowired
	BillDAO billdao;
	
	@Autowired
	MemberDAO memberdao;
	
	@RequestMapping(path = "PayBillForm.do", method = RequestMethod.POST)
	public ModelAndView payBillForm(Bill bill) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("bill", bill);
		mv.setViewName("paybill");

		return mv;
	}
	
	@RequestMapping(path="AddToFrugal.do", method=RequestMethod.POST)
	 public ModelAndView addToFrugal(@ModelAttribute("sessionUser") Member member, @RequestParam("amount") Double amount) {
		ModelAndView mv = new ModelAndView();
		
		accountdao.setFrugalSum(amount, member.getId());

		double amount2 = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		Member m = memberdao.showMember(member.getId());
		
		if (m.getAdmin() == true) {
			mv.addObject("member", m);
			mv.addObject("amount", amount2);
			mv.setViewName("adminProfile");
		} else {
			mv.addObject(m);
			mv.addObject("member", m);
			mv.addObject("amount", amount2);
			mv.setViewName("userProfile");
		}		
		 return mv;
	 }
	
	@RequestMapping(path="AddIncome.do", method=RequestMethod.POST)
	 public ModelAndView addIncome(@ModelAttribute("sessionUser") Member member, @RequestParam("amount") Double amount) {
		ModelAndView mv = new ModelAndView();
		
		accountdao.setBankAccount(amount, member.getId());
		
		double amount2 = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		Member m = memberdao.showMember(member.getId());
		
		if (m.getAdmin() == true) {
			mv.addObject("member", m);
			mv.addObject("amount", amount2);
			mv.setViewName("adminProfile");
		} else {
			mv.addObject(m);
			mv.addObject("member", m);
			mv.addObject("amount", amount2);
			mv.setViewName("userProfile");
		}	
		return mv;
	 }
	
	@RequestMapping(path="PayBill.do",
			 method=RequestMethod.POST)
	 public ModelAndView payBill(@ModelAttribute("sessionUser") Member member, @RequestParam("payid") Integer payid) {
		ModelAndView mv = new ModelAndView();

		billdao.payBill(payid, member.getAccount().getId());

		double amount = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		Member m = memberdao.showMember(member.getId());
		
		if (m.getAdmin() == true) {
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("adminProfile");
		} else {
			mv.addObject(m);
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("userProfile");
		}			
	
		 return mv;
	 }
	
	@RequestMapping(path="GetFrugalFamilySum.do", method=RequestMethod.POST)
	 public ModelAndView getFrugalFamilySum(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		
		double amount = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		
		Member m = memberdao.showMember(member.getId());

		if (m.getAdmin() == true) {
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("adminProfile");
		} else {
			mv.addObject(m);
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("userProfile");
		}		
		return mv;
	 }
	
}
