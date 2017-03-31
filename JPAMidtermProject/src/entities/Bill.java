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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<BillResponsibility> getBillResponsibilities() {
		return billResponsibilities;
	}

	public void setBillResponsibilities(List<BillResponsibility> billResponsibilities) {
		this.billResponsibilities = billResponsibilities;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	public Date getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billResponsibilities=" + billResponsibilities + ", family=" + family + ", member="
				+ member + ", name=" + name + ", amount=" + amount + ", dateDue=" + dateDue + ", datePaid=" + datePaid
				+ ", memberId=" + memberId + ", familyId=" + familyId + ", paid=" + paid + "]";
	}
	
}
