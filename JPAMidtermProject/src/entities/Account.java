package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Double bankAccount;

	private Double frugalSum;

	@OneToOne
	@JoinColumn(name="memberId")
	private Member member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Double bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Double getFrugalSum() {
		return frugalSum;
	}

	public void setFrugalSum(Double frugalSum) {
		this.frugalSum = frugalSum;
	}



	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", bankAccount=" + bankAccount + ", frugalSum=" + frugalSum + ", memberId="
				+ "]";
	}
}
