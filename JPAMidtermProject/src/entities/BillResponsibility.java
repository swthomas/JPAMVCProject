package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BillResponsibility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="billId")
	private Bill bill;
	
	private int percent;
	
	private int memberId;
	
	private int billId;

}
