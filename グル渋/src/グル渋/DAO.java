package グル渋;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DAO {
	String url = "jdbc:mysql://localhost:8080/GuruSibu?sslMode=DISABLED";
	public int login(String mail, String pass) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection(url, "root", "Gfreke38");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from user where email = '" + mail + "'");
				while (rs.next()) {
	                String pwd = rs.getString("password");
					if(pass.equals(pwd)) {
						int ret = rs.getInt("id");
						rs.close();
						stmt.close();
						con.close();
						return ret;
					}
				}
				rs.close();
				stmt.close();
				con.close();
				return 0;
				}catch(Exception e){
					System.out.println("MySQLに接続できませんでした。");
					return 0;
				}
	}

	public int makeAccount(String name, String mail,String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "Gfreke38");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO user (name,mail,password) VALUES ('" + name + "','" + mail + "','" + pwd + "')");
			stmt.close();
			con.close();
			return 0;
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
				return -1;
			}
	}
}