package data;

import entities.Family;

public interface FamilyDAO {

<<<<<<< HEAD
	public Family addFamily(Family family);

	Family updateFamily(Family family);

	boolean deleteFamily(int id);
	
	public Family getFamilyById(int id);
	
=======
	Family createFamily(Family newFam);
	Family updateFamily(Family fam);
	boolean deleteFamily(Family fam);
>>>>>>> 1d4188d1d88a2cfe936a61b1f6bda6d95c79730e
}
