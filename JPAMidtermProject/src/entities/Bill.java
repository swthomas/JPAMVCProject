package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="bill")
	private List<BillResponsibility> billResponsibilities;
	
	@ManyToOne
	@JoinColumn(name="familyId")
	private Family family;

	@ManyToOne
	@JoinColumn(name="memberId")
	private Member member;
	
	private String name;
	
	private double amount;
	
	private Date dateDue;
	
	private Date datePaid;
	
	private int memberId;
	
	private int familyId;
	
	private boolean paid;

}
