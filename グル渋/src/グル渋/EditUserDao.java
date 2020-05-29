package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EditUserDao {
	
	public int EditUser(int id,String name,String email,String password) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");	
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE user SET name='"+name+"',email='"+email+"',password='"+password+"' WHERE id='"+id+"'");
			return 0;			
        } catch (Exception e) {
            return -1;
        }
    }
}
