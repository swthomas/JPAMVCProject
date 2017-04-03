package data;

import entities.Family;

public interface FamilyDAO {

	Family createFamily(Family newFam);
	Family updateFamily(Family fam);
	String deleteFamily(int id);
}
