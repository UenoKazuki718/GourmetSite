package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {
	void setBook(int userId,int restaurantId,String date,int people,int courseId,String tel,String name){
		try {
			Class.forName("com.mysql.jdbc.Driver");			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO book (userId,restaurantId,date,people,courseId,tel,userName) VALUES ('"+userId+"','"+restaurantId+"','"+date+"','"+people+"','"+courseId+"','"+tel+"','"+name+"')");
			stmt.close();
			con.close();
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
			}
	}
	
	ArrayList<BookDetails> getBook(int id){
		 ArrayList<BookDetails> list = new ArrayList<BookDetails>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * FROM book JOIN restaurant ON book.restaurantId = restaurant.id JOIN course ON book.courseId = course.id WHERE userId = '" + id + "'");
		 			while (rs.next()) {
		 				list.add(new BookDetails(rs.getInt("restaurantId"),rs.getString("date"),rs.getInt("people"),rs.getInt("courseId"),rs.getString("tel"),rs.getString("userName"),rs.getString("name"),rs.getString("courseName")));
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。2");
		 			}
		 		return list;
	}
}
