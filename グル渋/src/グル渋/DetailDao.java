package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailDao {
	
	ArrayList<Rating> getReview(int id){
		 ArrayList<Rating> list = new ArrayList<Rating>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * from review WHERE restaurantId = '" + id + "'");
		 			while (rs.next()) {
		 				list.add(new Rating(rs.getInt("score"),rs.getString("text")));
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。1");
		 			}
		 		return list;
	}
	
	int getReviewAvg(int id){
		 //int list = new ArrayList<Rating>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT AVG(score) AS 'avg' from review WHERE restaurantId = '" + id + "'");
		 			while (rs.next()) {
		 				return rs.getInt("avg");
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。1");
		 			}
		 		return 0;
	}
	
	ArrayList<Menu> getMenu(int id){
		 ArrayList<Menu> list = new ArrayList<Menu>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * from menu WHERE menuId = '" + id + "'");
		 			while (rs.next()) {
		 				list.add(new Menu(rs.getInt("price"),rs.getString("name"),rs.getInt("isDish")));
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。2");
		 			}
		 		return list;
	}
	
	Restaurant getDetail(int id){
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * from restaurant WHERE id = '" + id + "'");
		 			while (rs.next()) {
		 				return new Restaurant(rs.getInt("id"), rs.getString("name"),rs.getString("information"),rs.getString("map"),rs.getString("address"),rs.getString("tel"),rs.getString("image"));
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。3");
		 			}
		 		return null;
	}
	
	ArrayList<String> getImage(int id){
		 ArrayList<String> list = new ArrayList<String>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * from image WHERE restaurantId = '" + id + "'");
		 			while (rs.next()) {
		 				list.add(rs.getString("image"));
		 			}
		 			rs.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。2");
		 			}
		 		return list;
	}
	
	ArrayList<Restaurant> searchDetail(String [] keyword){
		 //データベースに接続
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		String str = "";
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			String sql = "SELECT * from restaurant WHERE";
		 			for (int i = 0 ; i < keyword.length ; i++){
					      sql += " name  LIKE '%" + keyword[i] + "%' OR address LIKE '%" + keyword[i] + "%' OR";
					    }
		 			sql = sql.substring(0,sql.length() - 2); 
		 			ResultSet rs = stmt.executeQuery(sql);
		 			//ResultSet rs = stmt.executeQuery("SELECT * from restaurant WHERE name  LIKE '%" + keyword + "%' OR address LIKE '%" + keyword + "%'");
		 			while (rs.next()) {
		 				str += "'" + rs.getInt("id") + "',"; 
		 			}
		 			//ResultSet rs2 = stmt.executeQuery("SELECT * from category WHERE category  LIKE '%" + keyword + "%'");
		 			sql = "SELECT * from category WHERE";
		 			for (int i = 0 ; i < keyword.length ; i++){
					      sql += " category  LIKE '%" + keyword[i] + "%' OR";
					    }
		 			sql = sql.substring(0,sql.length() - 2);
		 			ResultSet rs2 = stmt.executeQuery(sql);
		 			while (rs2.next()) {
		 				str += "'" + rs2.getInt("restaurantId") + "',"; 
		 			}
		 			
		 			if(str != "") {
		 				str = str.substring(0,str.length() - 1); 
		 				ResultSet rs3 = stmt.executeQuery("SELECT * from restaurant WHERE id  IN (" + str + ")");
			 			while (rs3.next()) {
			 				list.add(new Restaurant(rs3.getInt("id"),rs3.getString("name"),rs3.getString("information"),rs3.getString("map"),rs3.getString("address"),rs3.getString("tel"),rs3.getString("image")));
			 			}
			 			rs3.close();
		 			}
		 			rs.close();
		 			rs2.close();
		 			stmt.close();
		 			con.close();
		 			}catch(Exception e){
		 				System.out.println("MySQLに接続できませんでした。");
		 			}
		 		return list;
	}
	
	ArrayList<Course> getCourse(int id){
		 ArrayList<Course> list = new ArrayList<Course>();
		 //データベースに接続
		 		try {
		 			Class.forName("com.mysql.jdbc.Driver");
		 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
		 			Statement stmt = con.createStatement();
		 			ResultSet rs = stmt.executeQuery("SELECT * from course WHERE restaurantId = '" + id + "'");
		 			while (rs.next()) {
		 				list.add(new Course(rs.getInt("id"),rs.getString("courseName"),rs.getInt("price"),rs.getString("detail")));
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
