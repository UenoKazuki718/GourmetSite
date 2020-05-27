package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookDao {
	void setBook(int userId,int restaurantId,String date,int people,int courseId,String tel,String name){
		try {
			Class.forName("com.mysql.jdbc.Driver");			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO book (userId,restaurantId,date,people,courseId,tel,name) VALUES ('"+userId+"','"+restaurantId+"','"+date+"','"+people+"','"+courseId+"','"+tel+"','"+name+"')");
			stmt.close();
			con.close();
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
			}
	}
	
}
