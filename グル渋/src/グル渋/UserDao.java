package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
    // データベース接続に使用する情報
    //final String jdbcId = "root";
    //final String jdbcPass = "admin";
    //final String jdbcUrl = "jdbc:mysql://localhost:8080/GuruSibu?serverTimezone=UTC";

    // ログインアカウントを探す
    public int findAccount(String email,String password) {

        // 戻り値の用意
        //UserBeans returnUb = new UserBeans();

        // データベースへ接続
        try  {
            Class.forName("com.mysql.jdbc.Driver");	
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, password, name, email FROM user WHERE email = '"+email+"' AND password = '"+password+"'");
            while (rs.next()) {
                return rs.getInt("id");

            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}