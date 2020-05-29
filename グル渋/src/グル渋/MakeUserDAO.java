package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MakeUserDAO {
    // データベース接続に使用する情報
        //final String jdbcId = "root";
        //final String jdbcPass = "Gfreke38";//"admin";
        //final String jdbcUrl = "jdbc:mysql://localhost:8080/GuruSibu";//?serverTimezone=UTC";


    public int MakeUserDAO(String name,String email,String password) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");	
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO user (name,email,password) VALUES ('"+name+"','"+email+"','"+password+"')");
			return 0;
			
        } catch (Exception e) {

            return -1;
        }
    }
}