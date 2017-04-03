package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
<<<<<<< HEAD
=======
	@OneToMany(mappedBy="family")
	private List<Bill> bills;
	
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e
	@OneToMany(mappedBy="family")
	private List<Member> members;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD
=======

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Family [id=" + id + ", members=" + members + ", name=" + name + "]";
	}

	
=======
		return "Family [id=" + id + ", bills=" + bills + ", members=" + members + ", name=" + name + "]";
	}
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e
	
}
