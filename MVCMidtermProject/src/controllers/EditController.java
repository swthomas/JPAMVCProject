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
	
	@RequestMapping(path = "EditBillForm.do", method = RequestMethod.POST)
	public ModelAndView editMemberBill(@RequestParam("id")Integer id) {
		ModelAndView mv = new ModelAndView();
		Bill b = billdao.getBill(id);
		mv.addObject("bill", b);
		mv.setViewName("editbill");
		return mv;
	}

	@RequestMapping(path = "EditBill.do", method = RequestMethod.POST)
	public ModelAndView editBill(HttpSession session,
			@ModelAttribute("sessionUser") Member member,
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("amount") double amount,
			@RequestParam("dateDue") String dueDate,
			@RequestParam("datePaid") String paidDate
			) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dDate = format.parse(dueDate);
		Bill bill = billdao.getBill(id);		
		
		if (!paidDate.equals("")){
		Date pDate = format.parse(paidDate);
		billdao.updateBill(bill, dDate, pDate, name, amount);
		}
		else {
			billdao.updateBill(bill, dDate, name, amount);
		}
		Member m = memberdao.showMember(member.getId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", m);
		
		if (m.getAdmin() == true) {
			mv.setViewName("adminProfile");			
		}
		else {
			mv.setViewName("userProfile");
		}	
		
		return mv;
	}


	
	@RequestMapping(path="DeleteBill.do",
			 method=RequestMethod.POST)
	 public ModelAndView removeBill(@ModelAttribute("sessionUser") Member member, @RequestParam("deleteid") Integer id) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(id + "Bill ID**************************");
		
		billdao.deleteBill(id);
		
		System.out.println(member.getId());
		System.out.println("###################################");
		
		Member m = memberdao.showMember(member.getId());
		
		mv.addObject("member", m);
		
		if (m.getAdmin() == true) {
			mv.setViewName("adminProfile");			
		}
		else {
			mv.setViewName("userProfile");
		}
		
		 return mv;

	 }
}
