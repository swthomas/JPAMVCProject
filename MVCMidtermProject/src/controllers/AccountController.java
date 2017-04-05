package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.AccountDAO;
import data.BillDAO;
import entities.Account;
import entities.Bill;
import entities.Member;

@Controller
public class AccountController {
	
	@Autowired
	AccountDAO accountdao;
	
	@Autowired
	BillDAO billdao;
	
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

	@RequestMapping(path = "AddBillForm.do", method = RequestMethod.POST)
	public ModelAndView addBillForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addBill");

		return mv;
	}
	
	@RequestMapping(path = "CreateFamilyBill.do", method = RequestMethod.POST)
	public ModelAndView addFamilyBill(@ModelAttribute("sessionUser") Member member, Bill bill) {
		System.out.println("FUCK YOU ***********************");
		ModelAndView mv = new ModelAndView();
		billdao.addBill(bill);
		mv.addObject(member);
		mv.setViewName("userPorfile");

		return mv;
	}
	
	@RequestMapping(path = "CreateMemberBill.do", method = RequestMethod.POST)
	public ModelAndView addBill(@ModelAttribute("sessionUser") Member member, Bill bill) {
		System.out.println("FUCK YOU ***********************");
		ModelAndView mv = new ModelAndView();
		billdao.addBill(bill);
		mv.addObject(member);
		mv.setViewName("userPorfile");

		return mv;
	}
}
