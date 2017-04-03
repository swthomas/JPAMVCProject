package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entities.Family;

public class FamilyDAOImpl implements FamilyDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/Frugaldb";
	private String user = "admin";
	private String pass = "admin";
	
	public FamilyDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

	@Override
	public Family addFamily(Family newFam) {
		
		int id = newFam.getId();
		String name = newFam.getName();


		String sql = "INSERT INTO family (id, name)";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql); // or (sql, Statement.RETURN_GENERATED_KEYS);)

			stmt.setInt(1, id);
			stmt.setString(2, name);
		

			int uc = stmt.executeUpdate();
			if (uc > 0) {
				return newFam;
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Family updateFamily(Family fam) {
		

		int id = fam.getId();
		String name = fam.getName();
        
        String sql = "UPDATE family SET id =?, "
        		+ "name = ?";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
			stmt.setString(2, name);

  
            int uc = stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fam;
    }

	@Override
	public String deleteFamily(int id) {
		String response = null;
        String sql = "DELETE FROM family WHERE id = ?";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int uc = stmt.executeUpdate();
            if (uc > 0 ) {
                response = "Family Deleted!";
            }
            else {
                response = "No Such Family Found!";
            }
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response = "Unable to delete Family!";
        }
        return response;
    }

	@Override
	public Family createFamily(Family family) {
		// TODO Auto-generated method stub
		return null;
	}

}
