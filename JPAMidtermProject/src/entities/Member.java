package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="familyId")
	private Family family;
	
	@OneToMany(mappedBy="member")
	private List<BillResponsibility> billResponsibilities;
	
	@OneToMany(mappedBy="member")
	private List<Bill> bills;
	
	@OneToOne
    @JoinColumn(name="member")
    private Account account;
	
	private String username;
	
	private String password;
	
	private String fName;
	
	private String lName;
	
	private int familyId;
	
	private Boolean admin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public List<BillResponsibility> getBillResponsibilities() {
		return billResponsibilities;
	}

	public void setBillResponsibilities(List<BillResponsibility> billResponsibilities) {
		this.billResponsibilities = billResponsibilities;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", family=" + family + ", billResponsibilities=" + billResponsibilities + ", bills="
				+ bills + ", account=" + account + ", username=" + username + ", password=" + password + ", fName="
				+ fName + ", lName=" + lName + ", familyId=" + familyId + ", admin=" + admin + "]";
	}
	
}
