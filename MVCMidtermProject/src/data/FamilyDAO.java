package data;

import entities.Family;

public interface FamilyDAO {

	public Family addFamily(Family family);

	Family updateFamily(Family family);

	boolean deleteFamily(int id);
	
	public Family getFamilyById(int id);

	boolean checkFamily(int id);
	
}
