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

}
