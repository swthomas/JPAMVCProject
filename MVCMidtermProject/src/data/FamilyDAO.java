package data;

import java.util.List;

import entities.Family;
import entities.Member;

public interface FamilyDAO {

	public Family addFamily(Family family);

	Family updateFamily(Family family);

	boolean deleteFamily(int id);

	public Family getFamilyById(int id);

	boolean checkFamily(String name);

	boolean checkUser(String name);

	List<Member> getMemberByFamily(int id);

}
