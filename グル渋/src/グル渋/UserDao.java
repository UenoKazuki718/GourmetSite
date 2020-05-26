package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tinyblog?serverTimezone=UTC";
	private final String DB_USER = "root";
	private final String DB_PASS = "admin";

	public User findUser(String userName) {
		Connection conn = null;
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			//conn = DriverManager.getConnection(url,"root","JW!mgc99wrd");

			// SELECTを実行
			String sql = "SELECT PASSWORD FROM USER WHERE name='" + userName + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT実行
			ResultSet rs = pStmt.executeQuery();

			// 結果をArrayListに格納
			while(rs.next()) {
				String password = rs.getString("PASSWORD");
				user = new User(userName, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}
}
