package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReviewDao {

	void setReview(int rating,String text,int restaurantId,int userId){
		try {
			Class.forName("com.mysql.jdbc.Driver");			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO review (score,text,restaurantId,userId) VALUES ('"+rating+"','"+text+"','"+restaurantId+"','"+userId+"')");
			stmt.close();
			con.close();
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
			}
	}
	
}
