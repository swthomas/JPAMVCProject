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
import entities.Account;
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

		Member temp = memberdao.showMember(member.getId());
		
		temp.getAccount().setFrugalSum(amount);

		Member m = memberdao.showMember(member.getId());

		mv.addObject("member", m);
		mv.setViewName("adminProfile");			
	
		 return mv;
	 }
	
	@RequestMapping(path = "SetBankAccount.do", method = RequestMethod.POST)
	public ModelAndView SetAccount(Account a, Double income) {
		ModelAndView mv = new ModelAndView();
		Account account = accountdao.setBankAccount(a);

		mv.addObject("account", account);
		mv.setViewName("*******");

		return mv;
	}
	
	@RequestMapping(path = "SetFrugalAccount.do", method = RequestMethod.POST)
	public ModelAndView show(Account a) {
		ModelAndView mv = new ModelAndView();
		Account account = accountdao.setFrugalSum(a);

		mv.addObject("account", account);
		mv.setViewName("*******");

		return mv;
	}
	
	@RequestMapping(path="PayBill.do",
			 method=RequestMethod.POST)
	 public ModelAndView payBill(@ModelAttribute("sessionUser") Member member, @RequestParam("payid") Integer id) {
		ModelAndView mv = new ModelAndView();

		billdao.payBill(id);

		Member m = memberdao.showMember(member.getId());
		
		mv.addObject("member", m);
		mv.setViewName("adminProfile");			
	
		 return mv;
	 }
}
