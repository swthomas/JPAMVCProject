package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class EditController {

	@Autowired
	AccountDAO accountdao;

	@Autowired
	BillDAO billdao;

	@Autowired
	MemberDAO memberdao;

	@RequestMapping(path = "GetBill.do", method = RequestMethod.POST)
	public ModelAndView getBill(@ModelAttribute("sessionUser") Bill bill) {
		ModelAndView mv = new ModelAndView();
		billdao.getBill(bill.getId());
		mv.addObject("bill", bill);
		mv.setViewName("editbill");

		return mv;
	}

	@RequestMapping(path = "EditUserForm.do", method = RequestMethod.POST)
	public ModelAndView getUserForm(@ModelAttribute("sessionUser") Member member) {
		ModelAndView mv = new ModelAndView();
				
		Member m = memberdao.showMember(member.getId());

		mv.addObject("member", m);
		mv.setViewName("edituser");

		return mv;
	}

	@RequestMapping(path = "EditUser.do", method = RequestMethod.POST)
	public ModelAndView editBill(HttpSession session, 
			@ModelAttribute("sessionUser") Member member, Member memberTemp) throws ParseException {
		ModelAndView mv = new ModelAndView();
		
		memberdao.updateMember(memberTemp);

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
	
	@RequestMapping(path = "EditBillForm.do", method = RequestMethod.POST)
	public ModelAndView editMemberBill(@ModelAttribute("sessionUser") Member member, @RequestParam("billid") Integer id) {
		ModelAndView mv = new ModelAndView();
		Bill b = billdao.getBill(id);
		mv.addObject("bill", b);
		mv.setViewName("editbill");
		System.out.println("EDITBILLFORM " + member.getId());
		return mv;
	}

	@RequestMapping(path = "EditBill.do", method = RequestMethod.POST)
	public ModelAndView editBill(HttpSession session, 
			@ModelAttribute("sessionUser") Member member,
			@RequestParam("billid") int billid, 
			@RequestParam("name") String name, 
			@RequestParam("amount") double amount,
			@RequestParam("dateDue") String dueDate, 
			@RequestParam("datePaid") String paidDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dDate = format.parse(dueDate);
		Bill bill = billdao.getBill(billid);
		
		if (!paidDate.equals("")) {
			Date pDate = format.parse(paidDate);
			billdao.updateBill(bill, dDate, pDate, name, amount);
		} else {
			billdao.updateBill(bill, dDate, name, amount);
		}

		ModelAndView mv = new ModelAndView();
		
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

	@RequestMapping(path = "DeleteBill.do", method = RequestMethod.POST)
	public ModelAndView removeBill(@ModelAttribute("sessionUser") Member member, @RequestParam("deleteid") Integer deleteid) {
		ModelAndView mv = new ModelAndView();

		billdao.deleteBill(deleteid);

		double amount = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		Member m = memberdao.showMember(member.getId());
		
		if (m.getAdmin() == true) {
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("adminProfile");
		} else {
			mv.addObject("member", m);
			mv.addObject("amount", amount);
			mv.setViewName("userProfile");
		}	

		return mv;
	}

	@RequestMapping(path = "DeleteAdminBill.do", method = RequestMethod.POST)
	public ModelAndView removeAdminBill(@ModelAttribute("sessionUser") Member member,
			@RequestParam("deleteid") Integer id) {
		ModelAndView mv = new ModelAndView();

		billdao.deleteAdminBill(id);

		double amount = accountdao.getFamilyFrugalTotal(member.getFamily().getId());
		Member m = memberdao.showMember(member.getId());

		mv.addObject("member", m);
		mv.addObject("amount", amount);
		mv.setViewName("adminProfile");

		return mv;
	}
}
