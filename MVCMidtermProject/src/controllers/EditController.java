package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.AccountDAO;
import data.BillDAO;
import entities.Account;
import entities.Bill;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class EditController {
	
	@Autowired
	AccountDAO accountdao;
	
	@Autowired
	BillDAO billdao;
	
//	@RequestMapping(path = "SetBankAccount.do", method = RequestMethod.POST)
//	public ModelAndView SetAccount(@ModelAttribute("sessionUser") Account a) {
//		ModelAndView mv = new ModelAndView();
//		Account account = accountdao.setBankAccount(a);
//
//		mv.addObject("account", account);
//		mv.setViewName("editbill");
//
//		return mv;
//	}
	
	@RequestMapping(path = "EditUserBill.do", method = RequestMethod.POST)
	public ModelAndView editUserBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		billdao.updateBill(bill);
		mv.addObject("bill", bill);
		mv.setViewName("editbill");
		
		return mv;
	}
	
	// Method to supply family.id from logged in user to the edit.jsp
	@RequestMapping(path = "editForm.do", method = RequestMethod.GET)
	public ModelAndView editForm(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("family", member.getFamily());
		mv.setViewName("edit");
		
		return mv;
	}
	
	
	@RequestMapping(path = "GetBill.do", method = RequestMethod.POST)
	public ModelAndView getBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		billdao.getBill(bill.getId());
		mv.addObject("bill", bill);
		mv.setViewName("editbill");
		
		return mv;
	}
	
	@RequestMapping(path = "EditAdminBill.do", method = RequestMethod.POST)
	public ModelAndView editAdminBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bill", billdao.getBill(bill.getId()));
		mv.setViewName("editadminbill");
		
		return mv;
	}
	
	@RequestMapping(path = "EditAdminBillFields.do", method = RequestMethod.POST)
	public ModelAndView editBeer(Bill bill){
		billdao.updateBill(bill);
		ModelAndView mv = new ModelAndView();
		mv.addObject("billlist", billdao.getFamilyBills(bill.getId()));
		mv.addObject("billlist", billdao.getMemberBills(bill.getId()));
		mv.setViewName("adminProfile");
		return mv;
		}

}
