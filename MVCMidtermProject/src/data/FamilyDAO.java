package data;

import entities.Family;

public interface FamilyDAO {

	Family addFamily(Family newFam);

	Family updateFamily(Family fam);

	String deleteFamily(int id);
	
	public Family createFamily(Family family);
	
}
