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
import data.MemberDAO;
import entities.Bill;
import entities.Member;

@Controller
@SessionAttributes("sessionUser")
public class EditController {
	
	@Autowired
	AccountDAO accountdao;
	
	@Autowired
	BillDAO billdao;

	@Autowired
	MemberDAO memberdao;
	
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
	
	@RequestMapping(path = "GetBill.do", method = RequestMethod.POST)
	public ModelAndView getBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		billdao.getBill(bill.getId());
		mv.addObject("bill", bill);
		mv.setViewName("editbill");

		return mv;
	}

	@RequestMapping(path = "EditUserBill.do", method = RequestMethod.POST)
	public ModelAndView editUserBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		billdao.updateBill(bill);
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
	public ModelAndView editAdminFields(@ModelAttribute("sessionUser") Member member, Bill bill) {
		billdao.updateBill(bill);
		Member m = memberdao.showMember(member.getId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", m);
		mv.setViewName("adminProfile");
		return mv;
	}

	@RequestMapping(path = "EditUserBillFields.do", method = RequestMethod.POST)
	public ModelAndView editUserFields(@ModelAttribute("sessionUser") Member member, Bill bill) {
		billdao.updateBill(bill);
		Member m = memberdao.showMember(member.getId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", m);
		mv.setViewName("userProfile");
		return mv;
	}

}
