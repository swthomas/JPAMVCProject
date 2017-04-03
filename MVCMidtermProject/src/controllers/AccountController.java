package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.AccountDAO;
import entities.Account;

@Controller
public class AccountController {
	
	@Autowired
	AccountDAO accountdao;
	
	@RequestMapping(path = "GetBankAccount.do", method = RequestMethod.GET)
	public ModelAndView GetAccount(Account a) {
		ModelAndView mv = new ModelAndView();
		Account account = accountdao.getAccount(a);

		mv.addObject("account", account);
		mv.setViewName("*******");

		return mv;
	}
	
	@RequestMapping(path = "SetBankAccount.do", method = RequestMethod.POST)
	public ModelAndView SetAccount(Account a) {
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

}
